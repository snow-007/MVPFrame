package com.dqm.mvpframe.http;

import com.dqm.mvpframe.model.bean.AppToken;
import com.dqm.mvpframe.model.bean.User;
import com.dqm.mvpframe.model.response.BaseResponse;
import com.dqm.mvpframe.model.response.StringResponse;
import com.dqm.mvpframe.utils.RxUtil;

import retrofit2.http.Body;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2017/2/15.
 */

public class ApiDataSource implements Api {
    private static volatile ApiDataSource instance;
    public static ApiDataSource getInstance() {
        if (instance == null) {
            synchronized (ApiDataSource.class){
                if (instance==null){
                    instance = new ApiDataSource();
                }
            }
        }
        return instance;
    }

    @Override
    public Observable<StringResponse> login(@Body User user) {
        return RetrofitHelper.createApi(Api.class).login(user).compose(RxUtil.rxSchedulerHelper());
    }

    @Override
    public Observable<BaseResponse<AppToken>> getAppToken(@Query("app_id") String appId, @Query("private_key") String privateKey) {
        return  RetrofitHelper.createApi(Api.class).getAppToken(appId, privateKey).compose(RxUtil.rxSchedulerHelper());
    }
}
