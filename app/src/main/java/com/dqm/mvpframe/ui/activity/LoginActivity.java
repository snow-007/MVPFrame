package com.dqm.mvpframe.ui.activity;

import android.os.Bundle;
import android.widget.Button;

import com.dqm.mvpframe.App;
import com.dqm.mvpframe.R;
import com.dqm.mvpframe.base.BaseActivity;
import com.dqm.mvpframe.dagger2.component.DaggerActivityComponent;
import com.dqm.mvpframe.dagger2.module.ActivityModule;
import com.dqm.mvpframe.model.bean.AppToken;
import com.dqm.mvpframe.presenter.LoginPresenter;
import com.dqm.mvpframe.presenter.contract.LoginContract;
import com.dqm.mvpframe.utils.RxUtil;
import com.dqm.mvpframe.utils.TipUtils;
import com.jakewharton.rxbinding.widget.RxTextView;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/2/7.
 */

public class LoginActivity extends BaseActivity implements LoginContract.View{
    private Button btnLogin;
    @Inject
    LoginPresenter presenter;


    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_login);
        DaggerActivityComponent.builder()
                .appComponent(App.getInstance().getAppComponent())
                .activityModule(new ActivityModule(this))
                .build()
                .inject(this);
        btnLogin = getViewById(R.id.btn_login);
        RxUtil.bindEvents(btnLogin, view -> {
            presenter.getKey();
        });

    }

    @Override
    public void showError(String msg) {

    }


    @Override
    public void getKeySuccess(AppToken appToken) {
        RxTextView.text(getViewById(R.id.tv_key)).call(appToken.getApp_token());
        TipUtils.showToast(this,"请求成功");
    }

    @Override
    public void getKeyFail(int code, String msg) {
        TipUtils.showToast(this,"获取失败");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
