package com.dqm.mvpframe.dagger2.module;

import com.dqm.mvpframe.app.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016/10/14 0014.
 */
@Module
public class AppModule {

    private final App mApp;

    public AppModule(App app) {
        this.mApp = app;
    }

    @Provides
    @Singleton
    public App provideApp() {
        return mApp;
    }

}