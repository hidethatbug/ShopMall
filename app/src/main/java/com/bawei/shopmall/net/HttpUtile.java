package com.bawei.shopmall.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.bawei.shopmall.api.ApiBase;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author:程金柱
 * Date:2019/6/17 15:32
 * Description：动态请求网络
 */

public class HttpUtile {
    private static HttpUtile httpUtile;
    private final Retrofit build;

    /**
     * 获取Retrofit.Builder()
     */
    private HttpUtile() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        build = new Retrofit.Builder()
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiBase.BASE_URL)
                .build();
    }

    /**
     * 双重锁
     *
     * @return
     */
    public static HttpUtile httpUtile() {
        if (httpUtile == null) {
            synchronized (HttpUtile.class) {
                if (httpUtile == null) {
                    httpUtile = new HttpUtile();
                }
            }
        }
        return httpUtile;
    }

    public boolean isNewWork(Context context){
        ConnectivityManager manager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
        if (activeNetworkInfo!=null){
            return activeNetworkInfo.isAvailable();
        }
        return false;
    }
    /**
     * 动态代理
     *
     * @param tClass
     * @param <T>
     * @return
     */
    public <T> T getNetRetrofit(Class<T> tClass) {
        return build.create(tClass);
    }


}
