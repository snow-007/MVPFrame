package com.dqm.mvpframe.http;


import com.dqm.mvpframe.model.bean.User;
import com.dqm.mvpframe.model.response.StringResponse;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Administrator on 2017/1/22.
 */

public interface Api {

    String HOST = "http://10.2.126.36:8080/DouDouService/";
    @POST("login")
    Observable<StringResponse> login(@Body User user);

}
