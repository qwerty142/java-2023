package edu.hw7;

import java.util.stream.LongStream;

public final class Task2 {
    private Task2() {}

    public static Long getFactorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException();
        }

        if (num == 0 || num == 1) {
            return 1L;
        }
        return LongStream.rangeClosed(2, num).parallel().reduce(1, (x, y) -> x * y);
    }
}
