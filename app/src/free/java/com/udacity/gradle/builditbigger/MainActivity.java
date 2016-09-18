package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.util.Pair;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.tanwang9408.jokemodule.JokeActivity;


public class MainActivity extends ActionBarActivity {

    private InterstitialAd mInterstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadInterstitial();



    }

    private void loadInterstitial(){
        mInterstitial=new InterstitialAd(this);
        mInterstitial.setAdUnitId(this.getString(R.string.interstitial_ad_unit_id));



        AdRequest adRequest=new AdRequest.Builder().build();
        mInterstitial.loadAd(adRequest);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showInterstitial(){
        if(mInterstitial.isLoaded()){
            mInterstitial.show();

        }



    }

    public void tellJoke(View view) {


        showInterstitial();
        EndpointsAsyncTask task=new EndpointsAsyncTask();
        task.execute(this);
        if(task.getStatus()== AsyncTask.Status.FINISHED) {



        }


    }


}
