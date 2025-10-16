package com.example.mobfactory;

import com.google.inject.AbstractModule;

public class MobFactoryModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MobFactory.class).to(RandomMobSelectionFactory.class); // Bind a different factory here to change
                                                                    // behaviour
        install(new SpawnableMobModule());
    }

}
