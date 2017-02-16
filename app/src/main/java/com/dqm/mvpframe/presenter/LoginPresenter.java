package com.dqm.mvpframe.presenter;

import com.dqm.mvpframe.http.ApiDataSouce;
import com.dqm.mvpframe.http.ResponseObserver;
import com.dqm.mvpframe.model.bean.User;
import com.dqm.mvpframe.model.response.StringResponse;
import com.dqm.mvpframe.presenter.contract.LoginContract;
import com.dqm.mvpframe.utils.LogUtils;

/**
 * Created by Administrator on 2017/1/22.
 */

public class LoginPresenter implements LoginContract.Presenter {
    private final LoginContract.View view;

        public LoginPresenter(LoginContract.View view) {
            this.view = view;
            this.view.setPresenter(this);
        }

        @Override
        public void login(String userName, String ueserPwd) {

            ApiDataSouce.getInstance().login(new User(userName,ueserPwd)).subscribe(new ResponseObserver<StringResponse>() {

                @Override
                public void onCompleted() {

                }

                @Override
                public void onSuccess(StringResponse stringResponse) {
                    LogUtils.i("111");
                }


            });

    }

    @Override
    public void attachView(Object view) {

    }

    @Override
    public void detachView() {

    }
}
