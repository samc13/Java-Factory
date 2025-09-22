package com.example.mob;

public abstract sealed class Mob permits Creeper, BabyZombie, Skeleton, Zombie, Cow {

    private final String name;
    private final SpawnRate spawnRate;
    private final int health;
    private final int attackDamage;

    protected Mob(
        final String name,
        final SpawnRate spawnRate,
        final int health,
        final int attackDamage
    ) {
        this.name = name;
        this.spawnRate = spawnRate;
        this.health = health;
        this.attackDamage = attackDamage;
    }

    @Override
    public String toString() {
        return "Mob Name: %s; Spawn-Rate: %s".formatted(getName(), getSpawnRate().name());
    }

    public String getName() {
        return this.name;
    }

    public SpawnRate getSpawnRate() {
        return this.spawnRate;
    }

    public int getHealth() {
        return this.health;
    }

    public int getAttackDamage() {
        return this.attackDamage;
    }
    
}