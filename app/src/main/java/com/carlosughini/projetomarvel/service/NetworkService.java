package com.carlosughini.projetomarvel.service;

import com.carlosughini.projetomarvel.models.CityListResponse;
import com.carlosughini.projetomarvel.models.ResponseJson;

import retrofit2.http.GET;
import rx.Observable;

public interface NetworkService {

    @GET("characters")
    Observable<ResponseJson> getCharactersList();

}
