package com.dqm.mvpframe.presenter;

import com.dqm.mvpframe.Constants;
import com.dqm.mvpframe.http.ApiDataSource;
import com.dqm.mvpframe.http.ResponseObserver;
import com.dqm.mvpframe.model.bean.AppToken;
import com.dqm.mvpframe.model.response.BaseResponse;
import com.dqm.mvpframe.presenter.contract.LoginContract;
import com.dqm.mvpframe.ui.activity.LoginActivity;

/**
 * Created by Administrator on 2017/1/22.
 */

public  class LoginPresenter extends LoginContract.Presenter {
    private final LoginContract.View mView;
    private LoginActivity mContext;

    public LoginPresenter(LoginContract.View view, LoginActivity context) {
        this.mView = view;
        this.mContext = context;
    }

    @Override
    public void getKey() {
        add(ApiDataSource.getInstance()
                .getAppToken(Constants.APP_ID, Constants.PRIVATE_KEY)
                .subscribe(new ResponseObserver<BaseResponse<AppToken>>(mContext,true) {
            @Override
            public void onSuccess(BaseResponse<AppToken> response) {
                mView.getKeySuccess(response.data);
            }

            @Override
            public void onFail(int code, String msg) {
                super.onFail(code, msg);
                mView.getKeyFail(code, msg);
            }
        }));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        clear();
    }
}
