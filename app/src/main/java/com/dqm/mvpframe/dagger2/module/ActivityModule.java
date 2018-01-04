package com.dqm.mvpframe.dagger2.module;

import android.app.Activity;

import com.dqm.mvpframe.dagger2.scopes.PerActivity;
import com.dqm.mvpframe.presenter.LoginPresenter;
import com.dqm.mvpframe.ui.activity.LoginActivity;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private LoginPresenter loginPresenter;
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @PerActivity
    public Activity provideActivity() {
        return mActivity;
    }

    public ActivityModule(LoginActivity activity) {
        loginPresenter = new LoginPresenter(activity, activity);
    }
    @Provides
    LoginPresenter provideLogin() {
        return loginPresenter;
    }

}
