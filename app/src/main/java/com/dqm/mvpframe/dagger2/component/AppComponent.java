package com.dqm.mvpframe.dagger2.component;

import com.dqm.mvpframe.app.App;
import com.dqm.mvpframe.dagger2.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2016/10/14 0014.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(App app);
}

