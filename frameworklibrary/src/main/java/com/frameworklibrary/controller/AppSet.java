package com.frameworklibrary.controller;


/**
 * @author znws-majin
 * @version :1
 * @CreateDate 2018年8月07日
 * @description :控制设置
 */
public class AppSet {
    public static final int     welcome         = 1;//引导页版本号
    public static final boolean isIMDebug       = false;//IM设为调试模式，打成正式包时，最好设为false，以免消耗额外的资源
    public static final int     login_minlenght = 6;//最小长度
    public static final int     login_maxlenght = 50;//最大长度

    /*#the net config*/
    public static final String PRODUCTION = "https:";//api.etongdai.com
    public static final String UPDATE     = "update";
    public static final String URL        = "com.devframework.http://192.168.4.230:8080/";



}
