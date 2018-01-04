package com.dqm.mvpframe;


import android.app.Application;

import com.dqm.mvpframe.dagger2.component.AppComponent;
import com.dqm.mvpframe.dagger2.component.DaggerAppComponent;
import com.dqm.mvpframe.dagger2.module.AppModule;
import com.zhy.autolayout.config.AutoLayoutConifg;

/******************************************
 * 类名称：App
 * 类描述：
 ******************************************/
public class App extends Application {
    private static App instance;
    private AppComponent mAppComponent;

    public synchronized static App getInstance() {
        if (instance == null) {
            instance = new App();
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //使用适配方式初始化
        AutoLayoutConifg.getInstance().useDeviceSize();
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}