package com.example;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.inject.Inject;

public class GameLoop {

    private static final int TICKS_PER_SECOND = 3;
    private static final long TICK_DURATION_MS = 1000 / TICKS_PER_SECOND;
    private final AtomicInteger tickCount = new AtomicInteger(0);

    private final GameTick gameTick;

    @Inject
    GameLoop(final GameTick gameTick) {
        this.gameTick = gameTick;
    }

    public void loop(AtomicBoolean running) {
        while (running.get()) {
            long tickStart = System.currentTimeMillis();

            int currentTick = tickCount.incrementAndGet();
            // --- Game tick logic ---
            log(currentTick);
            preventOverflow(currentTick);
            gameTick.run();
            // ----------------------

            long tickElapsed = System.currentTimeMillis() - tickStart;
            long sleepTime = TICK_DURATION_MS - tickElapsed;
            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
        System.out.println("Game loop stopped.");
    }

    private void log(int currentTick) {
        System.out.printf("Tick: %04d%n", currentTick);
        // if (currentTick % 10 == 0) {
        // System.out.println("10 ticks have passed.");
        // }
    }

    private void preventOverflow(int currentTick) {
        if (currentTick == Integer.MAX_VALUE) {
            System.out.println("Restarting tick counter.");
            tickCount.set(0); // Reset to avoid overflow
        }
    }

}
