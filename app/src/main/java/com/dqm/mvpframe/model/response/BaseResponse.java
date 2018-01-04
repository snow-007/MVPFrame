package com.dqm.mvpframe.model.response;

/**
 * Description:请求返回bean基类
 */
public class BaseResponse<T> {
    public String rsp_code;
    public String error_code;
    public String error_msg;
    public T data;


}
