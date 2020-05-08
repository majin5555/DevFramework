package com.devframework.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.devframework.MainActivity;
import com.devframework.R;
import com.devframework.base.BaseActivity;
import com.devframework.utils.ToastUtils;
import com.frameworklibrary.utils.SPUtils;

import butterknife.BindView;

/**
 * 登录页面
 */
public class LogInActivity extends BaseActivity {
    @BindView(R.id.login)
    Button   loginBtn;
    @BindView(R.id.register)
    Button   registerBtn;
    //    @BindView(R.id.visitor)
    //    TextView visitorText;
    @BindView(R.id.account)
    EditText accountText;
    @BindView(R.id.password)
    EditText passwordText;
    @BindView(R.id.login_remember)
    CheckBox isRememberPwd;
    @BindView(R.id.login_auto)
    CheckBox isAutoLogin;


    @Override
    protected int getLayoutResource() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListeners();
        // 自动填充
        SPUtils spu = new SPUtils(this);
        Boolean isRemember = spu.getBoolean("isRememberPwd", false);
        Boolean isAutoLogin = spu.getBoolean("isAutoLogin", false);
        // SharedPreference获取用户账号密码，存在则填充
        String account = spu.getString("account", "");
        String pwd = spu.getString("pwd", "");
        if (! account.equals("") && ! pwd.equals("")) {
            if (isRemember) {
                accountText.setText(account);
                passwordText.setText(pwd);
                isRememberPwd.setChecked(true);
            }
            if (isAutoLogin)
                Login();
        }
    }


    void setListeners() {
        loginBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });

        registerBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogInActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        //        visitorText.setOnClickListener(new OnClickListener() {
        //            @Override
        //            public void onClick(View v) {
        //                // 若已有游客账号则以游客身份登录，不存在则新建游客账号
        //                User visitor = DataSupport.where("isVisitor = ?","1")
        //                                          .findFirst(User.class);
        //                if(visitor == null){
        //                    visitor = new User();
        //                    visitor.setAccount("Visitor");
        //                    visitor.setPassword("Visitor");
        //                    visitor.setVisitor(true);
        //                    visitor.save();
        //                }
        //                UserManager.setCurrentUser(visitor);
        //                autoStartActivity(MainActivity.class);
        //            }
        //        });
    }

    /**
     * POST方式Login
     */
    private void Login() {
        autoStartActivity(MainActivity.class);


      /*  // 前端参数校验，防SQL注入
        String account = Util.StringHandle(accountText.getText().toString());
        String password = Util.StringHandle(passwordText.getText().toString());
        String resMsg = checkDataValid(account, password);
        if (! resMsg.equals("")) {
            showResponse(resMsg);
            return;
        }

        OptionHandle(account, password);// 处理自动登录及记住密码

        Map<String, Object> map = new HashMap<>();
        map.put("username", account);
        map.put("password", password);

        ApiSource.getInstance().login(map)//.compose(this.<BaseResponse<BeUserLogin>>bindUntilEvent(FragmentEvent.START))
                .subscribe(new ResponseObserver<BaseResponse<BeUserLogin>>(LogInActivity.this, true) {
                    @Override
                    public void onSuccess(BaseResponse<BeUserLogin> response) {
                        Logger.d("onSuccess--" + response.toString());
                        if (response.getCode() == 0) {
                            autoStartActivity(MainActivity.class);
                            showResponse(resMsg);
                        }
                    }

                    @Override
                    public void onFail(int code, String message) {
                        Logger.d("onFail--" + code + message);
                        showResponse("Network ERROR");
                    }
                });*/
    }

    private void showResponse(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ToastUtils.show(msg);
            }
        });
    }

    private String checkDataValid(String account, String pwd) {
        if (TextUtils.isEmpty(account) | TextUtils.isEmpty(pwd))
            return getResources().getString(R.string.null_hint);
        /**/
        //        if (account.length() != 11 && ! account.contains("@"))
        //            return getResources().getString(R.string.account_invalid_hint);
        return "";
    }

    void OptionHandle(String account, String pwd) {
        SPUtils spu = new SPUtils(this);
        if (isRememberPwd.isChecked()) {
            spu.putBoolean("isRememberPwd", true);
            // 保存账号密码
            spu.putString("account", account);
            spu.putString("pwd", pwd);
        } else {
            spu.putBoolean("isRememberPwd", false);
        }
        if (isAutoLogin.isChecked()) {
            spu.putBoolean("isAutoLogin", true);
        } else {
            spu.putBoolean("isAutoLogin", false);
        }
    }

}
