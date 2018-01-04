package com.dqm.mvpframe.dagger2.component;

import android.app.Activity;

import com.dqm.mvpframe.dagger2.module.ActivityModule;
import com.dqm.mvpframe.dagger2.scopes.PerActivity;
import com.dqm.mvpframe.ui.activity.LoginActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class})
public interface ActivityComponent {
    Activity getActivity();

    void inject(LoginActivity activity);
}