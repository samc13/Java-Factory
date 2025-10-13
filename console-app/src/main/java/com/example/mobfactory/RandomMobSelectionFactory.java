package com.example.mobfactory;

import java.util.Random;

import com.example.mob.BabyZombie;
import com.example.mob.Cow;
import com.example.mob.Creeper;
import com.example.mob.Mob;
import com.example.mob.Skeleton;
import com.example.mob.Zombie;
import com.example.mobfactory.MobFactory.Factory;

public class RandomMobSelectionFactory implements Factory {

    private final Random random = new Random();

    @Override
    public Mob create() {
        // TODO: Inject all mobs via Guice
        return switch (random.nextInt(5)) {
            case 0 -> new Creeper();
            case 1 -> new BabyZombie();
            case 2 -> new Skeleton();
            case 3 -> new Zombie();
            case 4 -> new Cow();
            default -> throw new IllegalStateException("Unexpected value");
        };
    }
}
