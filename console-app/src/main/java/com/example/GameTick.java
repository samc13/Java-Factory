package com.example;

import com.example.mobfactory.RandomMobSelectionFactory;
import com.example.mobfactory.Spawner;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class GameTick {

    private final Spawner spawner;
    private final RandomMobSelectionFactory mobFactory = new RandomMobSelectionFactory();

    @Inject
    public GameTick(
            final Spawner spawner) {
        this.spawner = spawner;
    }

    public void run() {
        spawner.spawn(mobFactory).ifPresent(mob -> System.out.println("A %s has spawned!".formatted(mob)));
    }

}
