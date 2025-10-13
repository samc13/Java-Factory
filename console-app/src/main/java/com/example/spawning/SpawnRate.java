package com.example.spawning;

import java.math.BigDecimal;

public enum SpawnRate {
    VERY_RARE(0.01),
    RARE(0.1),
    COMMON(0.25);

    private final BigDecimal rateMultiplier; 

    SpawnRate(final double rateMultiplier) {
        this.rateMultiplier = new BigDecimal(rateMultiplier);
    }

    public BigDecimal getRateMultiplier() {
        return this.rateMultiplier;
    } 
}
