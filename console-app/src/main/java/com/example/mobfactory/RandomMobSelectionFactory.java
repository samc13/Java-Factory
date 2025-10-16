package com.example.mobfactory;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

import com.example.mob.Mob;
import com.google.inject.Inject;

/**
 * A concrete implementation of {@link MobFactory} that randomly selects a mob
 * from a list of suppliers.
 */
final class RandomMobSelectionFactory implements MobFactory {

    private final Random random = new Random();

    private final List<Supplier<? extends Mob>> spawnableMobSuppliers;

    @Inject
    RandomMobSelectionFactory(
            final List<Supplier<? extends Mob>> spawnableMobSuppliers) {
        this.spawnableMobSuppliers = spawnableMobSuppliers;
    }

    @Override
    public Mob selectMob() {
        if (spawnableMobSuppliers == null || spawnableMobSuppliers.isEmpty()) {
            throw new IllegalStateException("No spawnable mobs available");
        }
        return spawnableMobSuppliers.get(random.nextInt(spawnableMobSuppliers.size())).get();
    }
}
