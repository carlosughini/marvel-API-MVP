package com.carlosughini.projetomarvel.ui;

import com.carlosughini.projetomarvel.models.CityListResponse;
import com.carlosughini.projetomarvel.models.ResponseJson;
import com.carlosughini.projetomarvel.service.NetworkError;
import com.carlosughini.projetomarvel.service.Service;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class ListCharactersPresenter {
    private final Service service;
    private final ListCharactersView view;
    private CompositeSubscription subscriptions;

    public ListCharactersPresenter(Service service, ListCharactersView view) {
        this.service = service;
        this.view = view;
        this.subscriptions = new CompositeSubscription();
    }

    public void getCharacterList() {
        view.showWait();

        Subscription subscription = service.getCharacterList(new Service.GetCharacterListCallback() {
            @Override
            public void onSuccess(ResponseJson responseJson) {
                view.removeWait();
                //view.getCharacterListSuccess(responseJson);
            }

            @Override
            public void onError(NetworkError networkError) {
                view.removeWait();
                view.onFailure(networkError.getAppErrorMessage());
            }

        });
        subscriptions.add(subscription);
    }

    public void onStop() {
        subscriptions.unsubscribe();
    }
}
