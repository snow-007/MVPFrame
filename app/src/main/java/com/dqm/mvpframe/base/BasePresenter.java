package com.dqm.mvpframe.base;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Description: BasePresenter
 */
public  class BasePresenter implements IPresenter {
    public CompositeSubscription mCompositeSubscription = new CompositeSubscription();// 管理订阅者者

    /**
     */
    @Override
    public void onDestroy() {
        this.mCompositeSubscription = null;
    }

    public void add(Subscription m) {
        mCompositeSubscription.add(m);
    }

    public void clear() {
        mCompositeSubscription.unsubscribe();// 取消订阅
    }

}