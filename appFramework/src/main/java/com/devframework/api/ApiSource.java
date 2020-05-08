package com.devframework.api;


import com.devframework.http.BaseResponse;
import com.devframework.http.RetrofitHelper;
import com.devframework.http.RxUtils;
import com.devframework.ui.login.bean.BeUserLogin;
import com.devframework.ui.login.bean.BeUserRegister;

import java.util.Map;

import io.reactivex.Observable;




public class ApiSource implements ApiService {

    private static volatile ApiSource instance = null;

    private ApiService getApi() {
        return RetrofitHelper.getInstance().createApi(ApiService.class);
    }

    private ApiService getApi(String baseUrl) {
        return RetrofitHelper.getInstance().createApi(ApiService.class, baseUrl);
    }

    public static ApiSource getInstance() {
        if (instance == null) {
            synchronized (ApiSource.class) {
                if (instance == null) {
                    instance = new ApiSource();
                }
            }
        }
        return instance;
    }

    /**
     * 登录
     */
    @Override
    public Observable<BaseResponse<BeUserLogin>> login(Map<String, Object> map) {
        return getApi().login(map).compose(RxUtils.rxSchedulerHelper());
    }


    /**
     * 注册
     */
    @Override
    public Observable<BaseResponse<BeUserRegister>> register(Map<String, Object> map) {
        return getApi().register(map).compose(RxUtils.rxSchedulerHelper());
    }
}
