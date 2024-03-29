package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.os.AsyncTask;
import android.test.ApplicationTestCase;



/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }


    public void testAsyncTask(){
        EndpointsAsyncTask task=new EndpointsAsyncTask();
        task.execute(getContext());
        if(task.getStatus()==AsyncTask.Status.FINISHED) {
            assertTrue(task.result != null);
            assertTrue(task.result.length() != 0);
        }



    }
}