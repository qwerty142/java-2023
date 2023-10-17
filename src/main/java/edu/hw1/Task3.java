package edu.hw1;

import java.util.Arrays;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public final class Task3 {
    private Task3() {
    }

    public static Pair<Integer, Integer> findMinAndMax(int[] array) {
        Integer minimum = Integer.MAX_VALUE;
        Integer maximum = Integer.MIN_VALUE;

        for (int elem : array) {
            if (elem <= minimum) {
                minimum = elem;
            }
            if (elem >= maximum) {
                maximum = elem;
            }
        }

        return new ImmutablePair<>(minimum, maximum);
    }

    public static boolean checkArrayOnNesting(int[] firstArray, int[] secondArray) {
        if (firstArray == null || secondArray == null) {
            return false;
        }
        if (firstArray.length == 0) {
            return secondArray.length != 0;
        } else if (secondArray.length == 0) {
            return false;
        }
        int minimumFirstArray;
        int maximumFirstArray;

        var newMinMax = findMinAndMax(firstArray);

        minimumFirstArray = newMinMax.getLeft();
        maximumFirstArray = newMinMax.getRight();

        boolean availabilityOfMin = minimumFirstArray > Arrays.stream(secondArray).min().getAsInt();
        boolean availabilityOfMax = maximumFirstArray < Arrays.stream(secondArray).max().getAsInt();

        return availabilityOfMin && availabilityOfMax;
    }
}
