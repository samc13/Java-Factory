package com.example;

import com.example.mobfactory.Spawner;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
class GameTick {

    private final Spawner spawner;

    @Inject
    GameTick(
            final Spawner spawner) {
        this.spawner = spawner;
    }

    public void run() {
        spawner.spawn().ifPresent(mob -> System.out.println("A %s has spawned!".formatted(mob)));
    }

}
