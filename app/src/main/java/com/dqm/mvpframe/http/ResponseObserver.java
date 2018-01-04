package com.dqm.mvpframe.http;

import android.content.Context;
import android.text.TextUtils;

import com.dqm.mvpframe.Constants;
import com.dqm.mvpframe.App;
import com.dqm.mvpframe.model.response.BaseResponse;
import com.dqm.mvpframe.utils.LogUtils;
import com.dqm.mvpframe.utils.NetworkUtils;
import com.dqm.mvpframe.widget.LoadingDialog;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * 自定义请求回调
 */
public abstract class ResponseObserver<T> extends Subscriber<T> implements OnFinishListener {

    private Context mContext;
    private boolean mAutoDismiss = false;
    private LoadingDialog mDialog;

    public ResponseObserver(Context context) {
        mContext = context;
    }

    public ResponseObserver(Context context, boolean autoDismiss) {
        mContext = context;
        this.mAutoDismiss = autoDismiss;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mAutoDismiss) {
            mDialog = new LoadingDialog(mContext);
        }
    }

    /**
     * 请求回调结束操作
     */
    @Override
    public void onFinish() {

    }

    @Override
    public void onFail(int code, String msg) {
        if (mAutoDismiss) {
            dismiss();
        }
    }

    @Override
    public void onCompleted() {
        onFinish();
        if (mAutoDismiss) {
            dismiss();
        }
    }
    public void dismiss() {
        mDialog.stopProgressDialog();
    }
    @Override
    public void onError(Throwable e) {
        if (e instanceof HttpException) {
            int code = ((HttpException) e).code();
            if (code == 401) {
                onFinish();
                return;
            }
        } else {
            if(NetworkUtils.isNetworkConnected(App.getInstance())){   //有网络
                onFail(Constants.FAILED_SERVER_EXCEPTION,"服务器异常");
            }else{
                onFail(Constants.FAILED_NO_NET,"没有网络");
            }
        }
        e.printStackTrace();
        onFailure(e);
        onFinish();
        LogUtils.i("返回数据","请求失败");


    }

    @Override
    public void onNext(T t) {
        if (t instanceof BaseResponse) {
            BaseResponse response = (BaseResponse) t;
            if(response.rsp_code.equals("fail")){   //请求失败
                onFail(Constants.FAILED, TextUtils.isEmpty(response.error_msg) ? "数据异常":response.error_msg);
                return;
            }
        }
        try {
            onSuccess(t);
            onFinish();
        } catch (Exception e) {
            e.printStackTrace();
            onError(e);
        }
        if (mAutoDismiss) {
            dismiss();
        }
    }

    public abstract void onSuccess(T t);

    public void onFailure(Throwable e) {
    }
}
