package com.example.mob;

import java.util.List;
import java.util.function.Supplier;

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
