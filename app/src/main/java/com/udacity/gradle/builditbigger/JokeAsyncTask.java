package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import com.example.kumar.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by Kumar on 10/26/2016.
 */

public class JokeAsyncTask extends AsyncTask<Context, Void, String>{

    MyApi myApi;
    Context mContext;
    TextView textView;

    public JokeAsyncTask(Context mContext, TextView textView){
        this.mContext = mContext;
        this.textView = textView;
        MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null).setRootUrl("https://builditbigger-148004.appspot.com/_ah/api/").setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
            @Override
            public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                request.setDisableGZipContent(true);
            }
        });
        myApi = builder.build();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected String doInBackground(Context... params) {
        String responseString = mContext.getString(R.string.error_response_string);
        try{
            responseString = myApi.getJoke().execute().getData();
        }catch (IOException e){
            e.printStackTrace();
        }
        return responseString;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        textView.setText(s);
    }
}
/**
 * https://developer.android.com/reference/android/os/AsyncTask.html
 * AsyncTask enables proper and easy use of the UI thread. This class allows you to perform
 * background operations and publish results on the UI thread without having to manipulate
 * threads and/or handlers.
 * AsyncTask is designed to be a helper class around Thread and Handler and does not constitute
 * a generic threading framework. AsyncTasks should ideally be used for short operations
 * (a few seconds at the most.) If you need to keep threads running for long periods of time,
 * it is highly recommended you use the various APIs provided by the java.util.concurrent package
 * such as Executor, ThreadPoolExecutor and FutureTask.
 * An asynchronous task is defined by a computation that runs on a background thread and whose
 * result is published on the UI thread. An asynchronous task is defined by 3 generic types,
 * called Params, Progress and Result, and 4 steps, called onPreExecute, doInBackground,
 * onProgressUpdate and onPostExecute.
 */
