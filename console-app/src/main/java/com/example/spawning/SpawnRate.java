package com.example.spawning;

import java.math.BigDecimal;
import java.util.Objects;

public enum SpawnRate {
    VERY_RARE(0.0025), // 0.25%
    RARE(0.01), // 1%
    COMMON(0.07); // 7%

    private final BigDecimal rateMultiplier;

    SpawnRate(final double rateMultiplier) {
        this.rateMultiplier = new BigDecimal(Objects.requireNonNull(rateMultiplier));

        if (this.rateMultiplier.compareTo(BigDecimal.ZERO) <= 0 || this.rateMultiplier.compareTo(BigDecimal.ONE) > 0) {
            throw new IllegalArgumentException("Rate multiplier must be > 0 and <= 1");
        }
    }

    public BigDecimal getRateMultiplier() {
        return this.rateMultiplier;
    }
}
