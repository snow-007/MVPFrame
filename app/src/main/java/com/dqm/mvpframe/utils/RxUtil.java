package com.dqm.mvpframe.utils;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.AdapterView;

import com.dqm.mvpframe.config.LViewClickOnSubscribe;
import com.jakewharton.rxbinding.widget.AdapterViewItemClickEvent;
import com.jakewharton.rxbinding.widget.RxAdapterView;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Description: RxUtil
 */
public class RxUtil {


    // 默认按钮防手抖时间(ms)
    public static final long THROTTLE_FIRST = 500;

    public static rx.Subscription bindEvents(View view, Action1<View> action) {
        return clicks(view).throttleFirst(THROTTLE_FIRST, TimeUnit.MILLISECONDS).subscribe(action);
    }

    @SuppressWarnings("unchecked")
    public static  rx.Subscription bindEvents(AdapterView view, Action1<AdapterViewItemClickEvent> action){
        return RxAdapterView.itemClickEvents(view).throttleFirst(THROTTLE_FIRST, TimeUnit.MILLISECONDS).subscribe(action);
    }

    private static Observable<View> clicks(@NonNull View view){
        return Observable.create(new LViewClickOnSubscribe(view));
    }
    /**
     * 统一线程处理
     *
     * @param <T>
     * @return
     */
    public static <T> Observable.Transformer<T, T> rxSchedulerHelper() {    //compose简化线程
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
