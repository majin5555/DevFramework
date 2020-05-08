package com.frameworklibrary.utils;

import android.content.Intent;

import com.frameworklibrary.base.BaseApplication;


public class IntentUtils extends Intent {

    public IntentUtils setClass(Class _class) {
        this.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.setClass(BaseApplication.mApplication, _class);
        return this;
    }

    public void start() {
        BaseApplication.mApplication.startActivity(this);
    }
}
