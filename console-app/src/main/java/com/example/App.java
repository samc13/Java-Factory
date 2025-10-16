package com.example;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class App {

    private final GameLoop gameLoop;

    @Inject
    public App(
            final GameLoop gameLoop) {
        this.gameLoop = gameLoop;
    }

    public void run() {
        AtomicBoolean running = new AtomicBoolean(true);

        Thread gameLoopThread = new Thread(() -> {
            gameLoop.loop(running);
        });

        System.out.println("Starting game loop...");
        gameLoopThread.start();

        // Main thread: listen for 'q' input to quit
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type 'q' and press Enter to quit.");
        while (running.get()) {
            String input = scanner.nextLine();
            if ("q".equalsIgnoreCase(input.trim())) {
                running.set(false);
                break;
            }
        }

        // Wait for game loop thread to finish
        try {
            gameLoopThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        scanner.close();
        System.out.println("Application terminated.");
    }

    public static void main(String[] args) {
        try {
            Injector injector = Guice.createInjector(new AppModule());
            App app = injector.getInstance(App.class);
            app.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
