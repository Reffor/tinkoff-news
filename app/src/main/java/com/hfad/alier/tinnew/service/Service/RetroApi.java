package com.hfad.alier.tinnew.service.Service;


import io.reactivex.Observable;
import com.hfad.alier.tinnew.service.models.ContentPayload;
import com.hfad.alier.tinnew.service.models.Payload;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetroApi {
    @GET("news")
    Observable<Payload> getNews();

    @GET("news_content")
    Observable<ContentPayload> getNews(@Query("id") String id);
}
