package com.free.simpletopupapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.free.simpletopupapp.R;

public class SplashScreenActivity extends AppCompatActivity {
    private long ms=0;
    //waktu tayang splashscreen 3000 millisecond = 3 detik
    private long splashTime = 3000;
    private boolean splashActive = true;
    private boolean paused = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread mythread = new Thread(){
            public void run(){
                try {
                    while (splashActive && ms < splashTime){
                        if(!paused)
                            ms=ms+100;
                        sleep(100);
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                } finally {
                    Intent i = new Intent(SplashScreenActivity.this, TopUpActivity.class);
                    finish();
                    startActivity(i);

                }
            }
        };
        mythread.start();
    }
}
