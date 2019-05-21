package com.hfad.alier.tinnew.service.Main;

import android.widget.Toast;

import com.hfad.alier.tinnew.service.Service.WebSevice;
import com.hfad.alier.tinnew.service.models.ContentPayload;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ContentPresernt implements ViewInterface{

    private String newId;
    private ViewPresenter viewPresenter;

    ContentPresernt(ViewPresenter viewPresenter){
        this.viewPresenter = viewPresenter;
    }

    @Override
    public void getNews(String id){
        newId = id;
        getObservable().subscribeWith(getObserver());
    }

    public Observable<ContentPayload> getObservable(){
        return WebSevice.getInstance().getRetroApi()
                .getNews(newId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<ContentPayload> getObserver(){
        return new DisposableObserver<ContentPayload>() {
            @Override
            public void onNext(ContentPayload contentPayload) {
                viewPresenter.showNewsContent(contentPayload.getPayload());
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
            }
        };
    }

}
