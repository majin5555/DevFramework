package com.devframework.api;


import com.devframework.http.BaseResponse;
import com.devframework.ui.login.bean.BeUserLogin;
import com.devframework.ui.login.bean.BeUserRegister;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 作者： Created by${raojianhui}
 * 日期：2018/8/13  11:29.
 * 项目：FrameDemo
 * 包名：com.example.jh.taokelink.api
 * 描述：api
 */

public interface ApiService {
    /**
     * 登录
     * @param map
     */
    @FormUrlEncoded
    @POST("user/login")
    Observable<BaseResponse<BeUserLogin>> login(@FieldMap Map<String, Object> map);

    /**
     * 注册
     * @param map
     */
    @FormUrlEncoded
    @POST("user/login")
    Observable<BaseResponse<BeUserRegister>> register(@FieldMap Map<String, Object> map);

}
