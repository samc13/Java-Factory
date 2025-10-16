package com.example.mobfactory;

import java.util.List;
import java.util.function.Supplier;

import com.example.mob.BabyZombie;
import com.example.mob.Cow;
import com.example.mob.Creeper;
import com.example.mob.Mob;
import com.example.mob.Skeleton;
import com.example.mob.Zombie;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class SpawnableMobModule extends AbstractModule {

    @Provides
    @Singleton
    List<Supplier<? extends Mob>> getSpawnableMobSuppliers() {
        return List.of(
                Creeper::new,
                BabyZombie::new,
                Skeleton::new,
                Zombie::new,
                Cow::new);
    }

}
