package com.tanwang9408.jokemodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static final String JOKE_EXTRA="Joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke2);

        TextView tv=(TextView)findViewById(R.id.joke_display);
        tv.setText(this.getIntent().getStringExtra(JOKE_EXTRA));





    }
}
