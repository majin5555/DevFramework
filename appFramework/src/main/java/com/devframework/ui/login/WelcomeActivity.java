package com.devframework.ui.login;

import android.content.Intent;
import android.os.Handler;
import android.util.Log;

import com.devframework.base.BaseActivity;
import com.frameworklibrary.utils.SPUtils;

/**
 * 欢迎页
 */
public class WelcomeActivity extends BaseActivity {

    @Override
    protected int getLayoutResource() {
        return 0;
    }

    @Override
    protected void initView() {
        //全屏
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                startNextActivity();
            }
        }, 1000);
    }

    @Override
    protected void initData() {
    }

    private void startNextActivity() {
        //1.读取状态信息？
        SPUtils sp = new SPUtils(this);
        boolean isUsed = sp.getBoolean("isUsed", false);
        //2.根据使用状态，启动下个页面
        if (isUsed) {//表示使用过
            Log.i("TAG", "进入登录页面");
            startActivity(new Intent(this, LogInActivity.class));
        } else {//没有使用过
            Log.i("TAG", "进入新手指导页");
            startActivity(new Intent(this, GuideActivity.class));
            sp.putBoolean("isUsed", true);
        }
        //3.关闭当前页面
        finish();
    }

    @Override
    public void onBackPressed() {
    }
}
