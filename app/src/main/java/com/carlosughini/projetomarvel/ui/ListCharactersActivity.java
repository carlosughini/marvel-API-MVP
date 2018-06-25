package com.carlosughini.projetomarvel.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.carlosughini.projetomarvel.BaseApp;
import com.carlosughini.projetomarvel.R;
import com.carlosughini.projetomarvel.models.CityListData;
import com.carlosughini.projetomarvel.models.CityListResponse;
import com.carlosughini.projetomarvel.models.Data;
import com.carlosughini.projetomarvel.models.ResponseJson;
import com.carlosughini.projetomarvel.service.Service;

import javax.inject.Inject;

public class ListCharactersActivity extends BaseApp implements ListCharactersView {

    private RecyclerView list;
    @Inject
    public Service service;
    ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDeps().inject(this);

        renderView();
        init();

        ListCharactersPresenter presenter = new ListCharactersPresenter(service, this);
        presenter.getCharacterList();
    }

    public  void renderView(){
        setContentView(R.layout.activity_home);
        list = findViewById(R.id.list);
        progressBar = findViewById(R.id.progress);
    }

    public void init(){
        list.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showWait() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeWait() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onFailure(String appErrorMessage) {

    }


    @Override
    public void getCharacterListSuccess(ResponseJson responseJson) {


    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
