package com.carlosughini.projetomarvel.ui;

import com.carlosughini.projetomarvel.models.CityListResponse;
import com.carlosughini.projetomarvel.models.ResponseJson;

public interface ListCharactersView {

    void showWait();

    void removeWait();

    void onFailure(String appErrorMessage);

    void getCharacterListSuccess(ResponseJson responseJson);

}
