package com.carlosughini.projetomarvel.service;

import com.carlosughini.projetomarvel.models.CityListResponse;
import com.carlosughini.projetomarvel.models.ResponseJson;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class Service {
    private final NetworkService networkService;

    public Service(NetworkService networkService) {
        this.networkService = networkService;
    }

    public Subscription getCharacterList(final GetCharacterListCallback callback) {

        return networkService.getCharactersList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends ResponseJson>>() {
                    @Override
                    public Observable<? extends ResponseJson> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<ResponseJson>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));

                    }

                    @Override
                    public void onNext(ResponseJson responseJson) {
                        callback.onSuccess(responseJson);

                    }
                });
    }

    public interface GetCharacterListCallback{
        void onSuccess(ResponseJson responseJson);

        void onError(NetworkError networkError);
    }
}