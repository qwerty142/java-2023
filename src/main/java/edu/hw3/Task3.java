package edu.hw3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Task3 {
    private Task3() {}

    private static final int ONE = 1;

    @SuppressWarnings("checkstyle:LambdaParameterName") public static <T>
    Map<T, Integer> freqDict(List<T> input) {
        if (input == null) {
            throw new NullPointerException("input cant be null");
        }
        Map<T, Integer> result = new HashMap<>();
        input.forEach(elem -> result.merge(elem, 1, Integer::sum));

        return result;
    }
}
