package com.dqm.mvpframe.presenter.contract;

import com.dqm.mvpframe.base.BasePresenter;
import com.dqm.mvpframe.base.BaseView;

/**
 * Description: MainContract
 */
public interface LoginContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {

        void login(String userName, String userPwd);
    }
}
