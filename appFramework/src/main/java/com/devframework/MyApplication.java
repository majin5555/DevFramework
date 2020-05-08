package com.devframework;

import android.content.Context;

import com.frameworklibrary.base.BaseApplication;


public class MyApplication extends BaseApplication {

    private static MyApplication mApp;
    private static Context       instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = getApplicationContext();
    }


    public static Context getContext() {
        return instance;
    }

    public synchronized static MyApplication getInstance() {
        if (mApp == null) {
            mApp = new MyApplication();
        }
        return mApp;
    }
}