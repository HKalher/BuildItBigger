package com.udacity.gradle.builditbigger;


import android.test.AndroidTestCase;

import org.junit.After;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import dalvik.annotation.TestTargetClass;

/**
 * Created by Kumar on 10/31/2016.
 */

public class JokeAsyncTest extends AndroidTestCase{

    JokeAsyncTask jokeAsyncTask;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        jokeAsyncTask = new JokeAsyncTask(getContext());
    }

    @Test
    public void TestJokeAsyncTask(){
        jokeAsyncTask.execute();
        try {
            assertNotNull(jokeAsyncTask.get(5, TimeUnit.SECONDS));
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }catch (TimeoutException e){
            e.printStackTrace();
        }
    }

}
