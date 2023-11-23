package edu.hw7;

import java.util.concurrent.atomic.AtomicLong;

public final class Task1 {
    Task1() {}

    private AtomicLong atomicLong = new AtomicLong(0);

    @SuppressWarnings("checkstyle:RegexpSinglelineJava")
    public Long countSumByThread(int amountOfAdd) {
        var thread1 = new Thread(() -> {
            for (int i = 0; i < amountOfAdd; i++) {
                atomicLong.incrementAndGet();
            }
        });
        var thread2 = new Thread(() -> {
            for (int i = 0; i < amountOfAdd; i++) {
                atomicLong.incrementAndGet();
            }
        });

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return atomicLong.get();
    }
}
