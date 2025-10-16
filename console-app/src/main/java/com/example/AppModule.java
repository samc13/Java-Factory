package com.example;

import com.example.mobfactory.MobFactoryModule;
import com.google.inject.AbstractModule;

public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(GameLoop.class).asEagerSingleton();
        install(new MobFactoryModule());
    }

}
