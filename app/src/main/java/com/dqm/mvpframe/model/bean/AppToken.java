package com.dqm.mvpframe.model.bean;


import com.dqm.mvpframe.model.response.BaseResponse;

public class AppToken extends BaseResponse {

    private String app_token="";
    private String security_code;

    public void setApp_token(String app_token) {
        this.app_token = app_token;
    }

    public void setSecurity_code(String security_code) {
        this.security_code = security_code;
    }

    public String getApp_token() {
        return app_token;
    }

    public String getSecurity_code() {
        return security_code;
    }

}
