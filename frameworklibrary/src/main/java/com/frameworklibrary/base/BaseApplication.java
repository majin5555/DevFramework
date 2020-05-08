package com.frameworklibrary.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.view.View;
import android.view.WindowManager;

import com.frameworklibrary.utils.SystemUtils;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

import java.util.ArrayList;
import java.util.List;


public abstract class BaseApplication extends Application implements Application.ActivityLifecycleCallbacks{
    public static BaseApplication mApplication;

    private Thread.UncaughtExceptionHandler mUncaughtExceptionHandler;
    private boolean                         mInstalled = false;

    private WindowManager  mWindowManager;
    private View           mView;
    //public  Net.Builder    mNetBuilder;

    private int            mJsonArrSize;
    private List<Activity> mActivityList    = new ArrayList<>();
    private boolean        mIsScreenAdapter = true;
    private int            mScreenWidth;

    public void pushActivity(Activity activity) {
        mActivityList.add(activity);
    }

    public void clearActivity() {
        for (Activity activity : mActivityList) {
            if (! activity.isFinishing()) {
                activity.finish();
            }
        }
        mActivityList.clear();
    }

    public void cleanJump() {
        this.cleanJump(null);
    }

    public void cleanJump(Class _class) {
        this.cleanJump(_class, - 1);
    }

    public void cleanJump(Class _class, int toSource) {
        List<Activity> activitys = SystemUtils.getActivities();
        if (activitys == null) return;
        for (Activity activity : activitys) {
            activity.finish();
        }

        Intent intent = new Intent();
        intent.setClass(this, _class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("source", toSource);
        startActivity(intent);
    }

    @SuppressLint("WrongConstant")
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        mApplication = this;
        //        install();
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB_MR2) {
            registerActivityLifecycleCallbacks(this);
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Debug.startMethodTracing(getPackageName());
        String pkgName = BaseApplication.mApplication.getPackageName();
        Logger.addLogAdapter(new AndroidLogAdapter(PrettyFormatStrategy.newBuilder().tag("majin").build()));
    }




    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }

}
