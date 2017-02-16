package com.dqm.mvpframe.app;


import android.app.Activity;
import android.app.Application;

import com.dqm.mvpframe.dagger2.component.DaggerAppComponent;
import com.zhy.autolayout.config.AutoLayoutConifg;

import java.util.HashSet;
import java.util.Set;

/******************************************
 * 类名称：App
 * 类描述：
 ******************************************/
public class App extends Application {

    private static App instance;
    private Set<Activity> allActivities;
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
        DaggerAppComponent.builder().build().inject(this);
    }

    /**
     * 添加Ativity
     * @param act
     */
    public void registerActivity(Activity act) {
        if (allActivities == null) {
            allActivities = new HashSet<>();
        }
        allActivities.add(act);
    }

    /**
     * 移除
     * @param act
     */
    public void unregisterActivity(Activity act) {
        if (allActivities != null) {
            allActivities.remove(act);
        }
    }

    /**
     * 退出app
     */
    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity act : allActivities) {
                    if (act != null && !act.isFinishing())
                        act.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

}