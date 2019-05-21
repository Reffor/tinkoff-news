package com.hfad.alier.tinnew.service.Main;


import com.hfad.alier.tinnew.service.Service.WebSevice;
import com.hfad.alier.tinnew.service.models.Payload;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class TitlePresenter implements ViewPresenterInterface{
    TitleInterface titleInterface;

    public TitlePresenter(TitleInterface titleInterface) {
        this.titleInterface = titleInterface;
    }

    public Observable<Payload> getObservable(){
        return WebSevice.getInstance().getRetroApi()
                .getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<Payload> getObserver(){
        return new DisposableObserver<Payload>() {

            @Override
            public void onNext(Payload payload) {
                titleInterface.showNews(payload);

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

    @Override
    public void getNews() {
        getObservable().subscribeWith(getObserver());
    }
}
