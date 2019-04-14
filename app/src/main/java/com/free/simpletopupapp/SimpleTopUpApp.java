package com.free.simpletopupapp;

import android.app.Application;
import android.content.Context;

public class SimpleTopUpApp extends Application {
    public static final String TAG = SimpleTopUpApp.class.getSimpleName();
    private static Context context;
    private static SimpleTopUpApp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
        SimpleTopUpApp.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return SimpleTopUpApp.context;
    }

    public static synchronized SimpleTopUpApp getInstance() {
        return mInstance;
    }
}
