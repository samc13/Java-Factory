package com.example.mob;

import com.example.spawning.SpawnRate;

public final class Creeper extends Mob {

    public Creeper() {
        super("Creeper", SpawnRate.RARE, 100, 250);
    }

}