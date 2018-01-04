package com.dqm.mvpframe.http;


import com.dqm.mvpframe.model.bean.AppToken;
import com.dqm.mvpframe.model.bean.User;
import com.dqm.mvpframe.model.response.BaseResponse;
import com.dqm.mvpframe.model.response.StringResponse;

import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2017/1/22.
 */

public interface Api {

    @POST("login")
    Observable<StringResponse> login(@Body User user);

    @POST("app/login")
    Observable<BaseResponse<AppToken>> getAppToken(@Query("app_id") String appId, @Query("private_key") String privateKey);

}
