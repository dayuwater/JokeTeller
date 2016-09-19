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
import android.widget.ProgressBar;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.tanwang9408.jokemodule.JokeActivity;


public class MainActivity extends ActionBarActivity {

    private InterstitialAd mInterstitial;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mInterstitial=new InterstitialAd(this);
        mInterstitial.setAdUnitId(this.getString(R.string.interstitial_ad_unit_id));
        mInterstitial.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                loadInterstitial();
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
            }

            @Override
            public void onAdLeftApplication() {
                super.onAdLeftApplication();

            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }
        });
        loadInterstitial();
        mProgressBar=(ProgressBar)findViewById(R.id.progressBar1);



    }

    @Override
    protected void onResume() {
        super.onResume();
        mProgressBar.setVisibility(View.GONE);
    }

    private void loadInterstitial(){




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
        mProgressBar.setVisibility(View.VISIBLE);


        showInterstitial();
        EndpointsAsyncTask task=new EndpointsAsyncTask();
         task.execute(this);
        Log.e("111",Integer.toString(mProgressBar.getVisibility()));


    }


}
