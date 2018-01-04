package com.dqm.mvpframe.dagger2.module;

import android.content.Context;

import com.dqm.mvpframe.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016/10/14 0014.
 */

@Module
public class AppModule {

    private Context context;

    public AppModule(Context context) {

        this.context = context;
    }

    @Provides
    @Singleton
    App provideApplication() {
        return (App) context.getApplicationContext();
    }

    @Provides
    @Singleton
    Context provideContext() {

        return context;
    }
}