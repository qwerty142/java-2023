package edu.hw7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("checkstyle:RegexpSingleline")
public final class Task4 {
    private Task4() {}

    private static final double PI_COEFFICIENT = 4;
    private static final double RADIUS = 1;
    private static final double CENTER_OF_CIRCLE = 0;

    public static double multiThreadMethod(int amountOfPoints, int amountOfThreads) {
        double pi = 0;
        List<ThreadForMultiThreads> threads = new ArrayList<>();
        for (int i = 0; i < amountOfThreads; i++) {
            threads.add(new ThreadForMultiThreads(amountOfPoints / amountOfThreads));
            threads.get(threads.size() - 1).start();
        }

        for (var elem : threads) {
            try {
                elem.join();
                pi += elem.amountOfCaughtPoints;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return (pi * PI_COEFFICIENT) / amountOfPoints;
    }

    public static double oneThreadMethod(int amountOfPoints) {
        return (countCaughtPoints(amountOfPoints) / amountOfPoints) * PI_COEFFICIENT;
    }

    @SuppressWarnings("checkstyle:LineLength")
    private static double countCaughtPoints(int amountOfPoints) {
        Random random = new Random();
        double amountOfCaughtPoints = 0;
        double x;
        double y;
        for (int i = 0; i < amountOfPoints; i++) {
            x = random.nextDouble() * 2 - 1;
            y = random.nextDouble() * 2 - 1;
            if (Math.pow(x, 2) + Math.pow(y, 2) <= RADIUS) {
                amountOfCaughtPoints++;
            }
        }
        return amountOfCaughtPoints;
    }

    @SuppressWarnings("checkstyle:FinalClass")
    private static class ThreadForMultiThreads extends Thread {
        public double amountOfCaughtPoints = 0;
        private final int amountOfPoints;

        ThreadForMultiThreads(int amountOfPoints) {
            this.amountOfPoints = amountOfPoints;
        }

        @Override
        public void start() {
            amountOfCaughtPoints += countCaughtPoints(amountOfPoints);
        }
    }
}
