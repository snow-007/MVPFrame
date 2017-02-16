package com.dqm.mvpframe.http;

import com.dqm.mvpframe.model.response.BaseResponse;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Description:自定义请求回调
 */
public abstract class ResponseObserver<T> extends Subscriber<T> implements OnFinishListener {

    public ResponseObserver() {
    }


    /**
     * 请求回调结束操作
     */
    @Override
    public void onFinish() {

    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof HttpException) {
            int code = ((HttpException) e).code();
            if (code == 401) {
                onFinish();
                return;
            }
        }
        e.printStackTrace();
        onFailure(e);
        onFinish();
    }

    @Override
    public void onNext(T t) {
        if (t instanceof BaseResponse) {
            BaseResponse response = (BaseResponse) t;
            //token 失效
            if (!response.success) {
                return;
            }
            //如果请求成功,但是返回结果失败
            if (!response.success) {
                return;
            }

        }
        try {
            onSuccess(t);
        } catch (Exception e) {
            e.printStackTrace();
            onError(e);
        }
    }

    public abstract void onSuccess(T t);

    public void onFailure(Throwable e) {
    }
}
