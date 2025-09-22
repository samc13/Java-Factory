package com.example.mobfactory;

import com.example.mob.Creeper;
import com.example.mob.Mob;
import com.example.mobfactory.MobFactory.Factory;

public class RandomMobFactory implements Factory {

    @Override
    public Mob create() {
        // TODO: make it random
        return new Creeper();
    }
    
}
