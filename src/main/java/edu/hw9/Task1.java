package edu.hw9;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task1 {
    private final ExecutorService threadPool;
    private final ConcurrentHashMap<String, Statistic> data;

    public Task1(int amountOfThreads) {
        if (amountOfThreads < 1) {
            throw new RuntimeException();
        }
        threadPool = Executors.newFixedThreadPool(Math
            .min(amountOfThreads, Runtime.getRuntime().availableProcessors()));
        this.data = new ConcurrentHashMap<>();
    }

    public ConcurrentHashMap<String, Statistic> getData() {
        threadPool.shutdown();
        return data;
    }

    public void addStats(String name, double[] stats) {
        if (threadPool.isTerminated()) {
            throw new RuntimeException();
        }

        threadPool.execute(() ->
            data.putIfAbsent(name, dataProcessing(stats)));
    }

    public Statistic dataProcessing(double[] data) {
        double sum = 0;
        double min = Double.MAX_VALUE;
        double medium = 0;

        for (var val : data) {
            sum += val;
            if (val < min) {
                min = val;
            }
        }
        medium = sum / data.length;
        return new Statistic(sum, min, medium);
    }
}
