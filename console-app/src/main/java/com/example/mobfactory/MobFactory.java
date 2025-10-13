package com.example.mobfactory;

import com.example.mob.Mob;

public class MobFactory {

    interface Factory {
        Mob create();
    }
}
