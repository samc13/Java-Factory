package com.example.mob;

import com.example.spawning.SpawnRate;

public final class Zombie extends Mob {

    public Zombie() {
        super("Zombie", SpawnRate.COMMON, 100, 100);
    }

}
