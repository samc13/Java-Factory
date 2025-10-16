package com.example;

import com.example.mobfactory.MobFactory;
import com.example.mobfactory.Spawner;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class GameTick {

    private final Spawner spawner;
    private final MobFactory mobFactory;

    @Inject
    public GameTick(
            final Spawner spawner,
            final MobFactory mobFactory) {
        this.spawner = spawner;
        this.mobFactory = mobFactory;
    }

    public void run() {
        spawner.spawn(mobFactory).ifPresent(mob -> System.out.println("A %s has spawned!".formatted(mob)));
    }

}
