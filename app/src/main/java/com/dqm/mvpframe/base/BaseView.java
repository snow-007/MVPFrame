package com.dqm.mvpframe.base;

/******************************************
 * 类名称：BaseView
 ******************************************/
public interface BaseView<T> {
    void setPresenter(T presenter);

    void showError(String msg);
}
