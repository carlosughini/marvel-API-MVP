package com.carlosughini.projetomarvel.deps;

import com.carlosughini.projetomarvel.service.NetworkModule;
import com.carlosughini.projetomarvel.ui.ListCharactersActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class,})
public interface Deps {
    void inject(ListCharactersActivity listCharactersActivity);
}