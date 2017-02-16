package com.dqm.mvpframe.base;

/**
 * Description: BasePresenter
 */
public interface BasePresenter<T> {
    void attachView(T view);

    void detachView();
}
