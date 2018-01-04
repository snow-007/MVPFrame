package com.dqm.mvpframe.presenter.contract;
import com.dqm.mvpframe.base.BasePresenter;
import com.dqm.mvpframe.base.BaseView;
import com.dqm.mvpframe.model.bean.AppToken;

/**
 * Description: MainContract
 */
public interface LoginContract {
    interface View extends BaseView<Presenter> {

        void getKeySuccess(AppToken appToken);

        void getKeyFail(int code, String msg);

    }

    abstract class Presenter extends BasePresenter {
        public abstract void getKey();
    }
}
