package com.kalher.henu.jokeandroidlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.security.AccessController.getContext;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView jokeTextView = (TextView) findViewById(R.id.joke_content_textview);
        String joke = getIntent().getStringExtra("joke");

        jokeTextView.setText(joke);
    }
}
