package edu.hw8.Task2;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class FixedThreadPool implements ThreadPool{
    private final BlockingDeque<Runnable> tasks;
    private final Thread[] threads;

    public FixedThreadPool(int amountOfThreads) {
        if (amountOfThreads < 1) {
            throw new IllegalArgumentException();
        }
        tasks = new LinkedBlockingDeque<>();
        int realSize = Math.min(amountOfThreads, Runtime.getRuntime().availableProcessors());
        threads = new Thread[realSize];
    }

    public static FixedThreadPool create(int amountOfThreads) {
        return new FixedThreadPool(amountOfThreads);
    }
    @Override
    public void start() {
        for(int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                while (true) {
                    try {
                        tasks.take().run();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            threads[i].start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        try {
            tasks.put(runnable);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws Exception {
        for (var thread : threads) {
            thread.interrupt();
        }
    }
}
