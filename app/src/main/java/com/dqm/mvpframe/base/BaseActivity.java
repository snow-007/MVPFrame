package com.dqm.mvpframe.base;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dqm.mvpframe.app.App;
import com.dqm.mvpframe.utils.LogUtils;

/**
 * Created by Administrator on 2017/1/22.
 */

public  abstract class BaseActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getInstance().registerActivity(this);
        initView(savedInstanceState);
    }

    protected abstract void initView(Bundle savedInstanceState);


    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.d(this.getClass().getName() + "------>onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.d(this.getClass().getName() + "------>onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.d(this.getClass().getName() + "------>onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.d(this.getClass().getName() + "------>onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.d(this.getClass().getName() + "------>onStop");
    }

    /**
     * 查找View
     *
     * @param id   控件的id
     * @param <VT> View类型
     * @return
     */
    @SuppressWarnings("unchecked")
    protected <VT extends View> VT getViewById(@IdRes int id) {
        return (VT) this.findViewById(id);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.d(this.getClass().getName() + "------>onDestroy");
        App.getInstance().unregisterActivity(this);
    }
}