package com.udacity.gradle.builditbigger;

import android.content.Context;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.util.Log;
import android.widget.Toast;


import com.example.tanwang.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.tanwang9408.jokemodule.JokeActivity;

import java.io.IOException;

/**
 * Created by tanwang on 8/31/16.
 */
public class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    public String result;



    @Override
    protected String doInBackground(Context... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("https://joketeller-142014.appspot.com/_ah/api/");


            // end options for devappserver

            myApiService = builder.build();
        }

        context=params[0];



        try {
            String result=myApiService.tellJoke().execute().getData();
            Log.e("111",result);
            return result;
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Intent intent=new Intent(context,JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE_EXTRA, result);
        context.startActivity(intent);
        this.result=result;
    }
}
