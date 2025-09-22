package com.example.mobfactory;

import com.example.environments.Environment;
import com.example.mob.Cow;
import com.example.mob.Mob;
import com.example.mob.Skeleton;
import com.example.mob.Zombie;
import com.example.mobfactory.MobFactory.Factory;
import com.google.inject.Inject;

public class EnvironmentMobFactory implements Factory {

    private final Environment environment;

    @Inject
    EnvironmentMobFactory(
            final Environment environment
    ) {
        this.environment = environment;
    }

    @Override
    public Mob create() {
       return switch (environment) {
            case CAVE -> new Skeleton();
            case GRASSLAND -> new Cow();
            default -> new Zombie();
        };
    }

}
