package com.devframework.http;

/**
 * Created by dqm on 2018/3/26.
 * 基本数据基类
 */

public class BaseResponse<T> {
    public int    code;//			响应代码 1:查询成功
    public int    count;//			响应代码 1:查询成功
    public String msg; //			查询成功 查询失败
    public T      data;

    public int getCode() {
        return code;
    }

    public int getCount() {
        return count;
    }

    public String getMsg() {
        return msg == null ? "" : msg;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code=" + code +
                ", count=" + count +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
