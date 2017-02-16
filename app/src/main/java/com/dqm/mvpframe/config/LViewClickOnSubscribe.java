package com.dqm.mvpframe.config;

import android.view.View;

import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

import static com.jakewharton.rxbinding.internal.Preconditions.checkUiThread;

/**
 */
public class LViewClickOnSubscribe implements Observable.OnSubscribe<View> {
    private final View view;

    public LViewClickOnSubscribe(View view) {
        this.view = view;
    }

    @Override
    public void call(final Subscriber<? super View> subscriber) {
        checkUiThread();
        View.OnClickListener listener = v -> {
            if (!subscriber.isUnsubscribed()) {
                subscriber.onNext(v);
            }
        };
        view.setOnClickListener(listener);

        subscriber.add(new MainThreadSubscription() {
            @Override
            protected void onUnsubscribe() {
                view.setOnClickListener(null);
            }
        });
    }
}
