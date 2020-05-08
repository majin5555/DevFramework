package com.devframework.base;

import android.content.Intent;
import android.os.Bundle;

import com.devframework.utils.ActivityController;
import com.orhanobut.logger.Logger;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import androidx.annotation.Nullable;
import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;

/**
 * 基类活动
 */

public abstract class BaseActivity extends RxAppCompatActivity {

    public String TAG = this.getClass().getName();

    public CompositeDisposable mCompositeDisposable;

    protected abstract int getLayoutResource();

    protected abstract void initView();

    protected abstract void initData();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityController.addActivity(this);
        int layout = getLayoutResource();
        if (layout != 0) {
            setContentView(layout);
        }
        //初始化控件
        ButterKnife.bind(this);
        mCompositeDisposable = new CompositeDisposable();//Rxjava订阅初始化
        initView();
        initData();
    }

    public void autoStartActivity(Class T) {
        Intent intent = new Intent(this, T);
        startActivity(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ActivityController.removeActivity(this);
        mCompositeDisposable.dispose();
        Logger.d("BaseActivity  onDestroy");
    }
}
