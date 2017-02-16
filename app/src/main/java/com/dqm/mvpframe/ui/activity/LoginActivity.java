package com.dqm.mvpframe.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.dqm.mvpframe.R;
import com.dqm.mvpframe.base.BaseActivity;
import com.dqm.mvpframe.presenter.LoginPresenter;
import com.dqm.mvpframe.presenter.contract.LoginContract;
import com.dqm.mvpframe.utils.RxUtil;

/**
 * Created by Administrator on 2017/2/7.
 */

public class LoginActivity extends BaseActivity implements LoginContract.View{
    private EditText etUser,etPass;
    private Button btnLogin;
    private LoginContract.Presenter presenter;


    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_login);
        presenter = new LoginPresenter(this);
        etUser = getViewById(R.id.et_user);
        etPass = getViewById(R.id.et_pass);
        btnLogin = getViewById(R.id.btn_login);

        RxUtil.bindEvents(btnLogin, view -> {
            presenter.login(etUser.getText().toString(),etPass.getText().toString());
        });

    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showError(String msg) {

    }
}
