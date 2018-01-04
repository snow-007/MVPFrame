package com.dqm.mvpframe.http;

import android.support.v7.appcompat.BuildConfig;

import com.dqm.mvpframe.Constants;

import java.util.concurrent.TimeUnit;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Description: RetrofitHelper
 */
public class RetrofitHelper {

    private static final int TIME = 10;
    private static OkHttpClient okHttpClient = null;

    public static <T> T createApi(Class<T> clazz) {
        return createApi(clazz, Constants.HOST);
    }

    public static <T> T createApi(Class<T> clazz, String url) {
        initOkHttp();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(clazz);
    }

    private static void initOkHttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builder.addInterceptor(loggingInterceptor);
        }
//        SSL证书
        builder.sslSocketFactory(TrustManager.getUnsafeOkHttpClient());
        builder.hostnameVerifier(new TrustManager.TrustAllHostnameVerifier());
        //设置超时
        builder.connectTimeout(TIME, TimeUnit.SECONDS);
        builder.readTimeout(TIME, TimeUnit.SECONDS);
        builder.writeTimeout(TIME, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);
        okHttpClient = builder.build();

    }

}
