package com.example.mobfactory;

import java.util.Optional;

import com.example.mob.Mob;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class Spawner {

    @Inject
    public Spawner() {

    }

    public Optional<Mob> spawn(final MobFactory.Factory mobFactory) {
        return mobFactory.create().getSpawnRate().getRateMultiplier().doubleValue() > Math.random()
                ? Optional.of(mobFactory.create())
                : Optional.empty();
    }

}
