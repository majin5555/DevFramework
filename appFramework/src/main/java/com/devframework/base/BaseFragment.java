package com.devframework.base;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;



public abstract class BaseFragment extends RxFragment {
    public  String              TAG = this.getClass().getName();
    private Activity            mActivity;
    private View                mCacheView;
    private Unbinder            unbinder;
    public  CompositeDisposable mCompositeDisposable;

    protected abstract int getLayoutResource();

    protected abstract void initView();

    protected abstract void initData();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mActivity = getActivity();
    }

    /**
     * 页面开始创建
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (mCacheView == null) {
            mCacheView = inflater.inflate(getLayoutResource(), null);
        }
        ViewGroup parent = (ViewGroup) mCacheView.getParent();
        if (parent != null) {
            parent.removeView(mCacheView);
        }
        unbinder = ButterKnife.bind(this, mCacheView);

        mCompositeDisposable = new CompositeDisposable();//Rxjava订阅初始化

        initView();

        return mCacheView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        mCompositeDisposable.dispose();
    }
}
