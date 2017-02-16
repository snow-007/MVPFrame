package com.dqm.mvpframe.http;

import com.dqm.mvpframe.model.bean.User;
import com.dqm.mvpframe.model.response.StringResponse;
import com.dqm.mvpframe.utils.RxUtil;

import retrofit2.http.Body;
import rx.Observable;

/**
 * Created by Administrator on 2017/2/15.
 */

public class ApiDataSouce implements Api {
    private static ApiDataSouce instance;
    public static ApiDataSouce getInstance() {
        if (instance == null) {
            synchronized (ApiDataSouce.class){
                if (instance==null){
                    instance = new ApiDataSouce();
                }
            }
        }
        return instance;
    }

    @Override
    public Observable<StringResponse> login(@Body User user) {
        return RetrofitHelper.getApi().login(user).compose(RxUtil.rxSchedulerHelper());
    }
}
