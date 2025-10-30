package com.example.mobfactory;

import java.util.Optional;
import java.util.function.Predicate;

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
        return Optional.of(mobFactory.selectMob())
                .filter(attemptSpawn());
    }

    private Predicate<Mob> attemptSpawn() {
        return mob -> mob.getSpawnRate().getRateMultiplier().doubleValue() > Math.random();
    }

}
