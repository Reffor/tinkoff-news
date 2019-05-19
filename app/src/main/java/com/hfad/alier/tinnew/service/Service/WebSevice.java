package com.hfad.alier.tinnew.service.Service;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class WebSevice {
    private static WebSevice wInstance;
    private static final String BASE_URL = "https://api.tinkoff.ru/v1/news";
    private Retrofit mRetrofit;

    private WebSevice(){
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static WebSevice getInstance(){
        if (wInstance == null){
            wInstance = new WebSevice();
        }
        return wInstance;
    }

    public RetroApi getRetroApi(){
        return mRetrofit.create(RetroApi.class);
    }
}
