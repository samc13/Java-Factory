package com.example.mobfactory;

import java.util.Optional;

import com.example.mob.Mob;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class Spawner {

    private final MobFactory mobFactory;

    @Inject
    Spawner(final MobFactory mobFactory) {
        this.mobFactory = mobFactory;
    }

    public Optional<Mob> spawn() {
        return mobFactory.selectMob().getSpawnRate().getRateMultiplier().doubleValue() > Math.random()
                ? Optional.of(mobFactory.selectMob())
                : Optional.empty();
    }

}
