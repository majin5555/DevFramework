package com.devframework.ui.login;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.devframework.Constants;
import com.devframework.R;
import com.devframework.api.ApiSource;
import com.devframework.base.BaseActivity;
import com.devframework.http.BaseResponse;
import com.devframework.http.ResponseObserver;
import com.devframework.ui.login.bean.BeUserRegister;
import com.devframework.utils.ToastUtils;
import com.devframework.utils.Util;
import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

/**
 * @author: majin
 * @date: 2019/07/17
 */

public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.register_confirm)
    Button    registerBtn;
    @BindView(R.id.register_cancel)
    Button    cancelBtn;
    @BindView(R.id.register_account)
    EditText  accountText;
    @BindView(R.id.register_pwd)
    EditText  pwdText;
    @BindView(R.id.register_pwd_confirm)
    EditText  confirmPwdText;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_register;
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
        initComponents();
        setListeners();
    }

    void initComponents() {

    }

    /**
     * 绑定点击事件
     */
    void setListeners() {
        back.setOnClickListener(this);
        registerBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
            case R.id.register_cancel:
                finish();
                break;
            case R.id.register_confirm:
                register();
                break;
            default:
                break;
        }
    }

    /**
     * POST方式Register
     */
    private void register() {

        // 前端参数校验，防SQL注入
        String account = Util.StringHandle(accountText.getText().toString());
        String pwd = Util.StringHandle(pwdText.getText().toString());
        String pwd_confirm = Util.StringHandle(confirmPwdText.getText().toString());

//        // 检查数据格式是否正确
//        String resMsg = checkDataValid(account, pwd, pwd_confirm);
//        if (! resMsg.equals("")) {
//            showResponse(resMsg);
//            return;
//        }

        /**注册*/
        Map<String, Object> map = new HashMap<>();
        map.put("username", "mj001");
        map.put("password", "666666");
        ApiSource.getInstance().register(map)
                .subscribe(new ResponseObserver<BaseResponse<BeUserRegister>>(RegisterActivity.this, true) {
                    @Override
                    public void onSuccess(BaseResponse<BeUserRegister> response) {
                        Logger.d("onSuccess--" + response.toString());
                        if (response.getCode() == Constants.SUCCESSCODE_REGISTER) {
                            // 显示注册结果
                            showResponse(response.getMsg() + "注册成功");
                            finish();
                        }
                    }

                    @Override
                    public void onFail(int code, String message) {
                        Logger.d("onFail--" + code + message);
                        showResponse("Network ERROR");
                    }
                });
    }

    private void showResponse(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ToastUtils.show(msg);
            }
        });
    }

    private String checkDataValid(String account, String pwd, String pwd_confirm) {
        if (TextUtils.isEmpty(account) | TextUtils.isEmpty(pwd) | TextUtils.isEmpty(pwd_confirm))
            return getResources().getString(R.string.null_hint);
        if (! pwd.equals(pwd_confirm))
            return getResources().getString(R.string.not_equal_hint);
        if (account.length() != 11 && ! account.contains("@"))
            return getResources().getString(R.string.account_invalid_hint);
        return "";
    }


}
