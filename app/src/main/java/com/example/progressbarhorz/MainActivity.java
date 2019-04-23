package com.example.progressbarhorz;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ProgressBar myProgressBar;
    Handler myHandler;
    Runnable myRunnable;
    Timer myTimer;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //don't forget to declare the variables in this code int i should=0;

                myProgressBar = (ProgressBar) findViewById(R.id.progressBar);
                myProgressBar.setVisibility(View.VISIBLE);
                myProgressBar.setProgress(0);
                myProgressBar.setSecondaryProgress(0);
                myProgressBar.setMax(100);
                myHandler = new Handler();
                myRunnable = new Runnable() {
                    @Override
                    public void run() {
                        if (i++ <= 100) {

                            myProgressBar.setProgress(i);
                            myProgressBar.setSecondaryProgress(i + 10);
                        } else {

                            myTimer.cancel();
                        }


                    }
                };
                myTimer = new Timer();

                myTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        myHandler.post(myRunnable);
                    }
                }, 2000, 50);
    }
}
