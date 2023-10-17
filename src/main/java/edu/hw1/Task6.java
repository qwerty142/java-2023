package edu.hw1;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Task6 {
    private Task6() {
    }

    private static final int MIN_VAL_NUM = 1000;
    private static final int KEPLER_NUM = 6174;
    private static final int MAX_VAL_NUM = 9999;

    public static int getKaprekerNum(int n, int steps) {
        if (n < MIN_VAL_NUM || n > MAX_VAL_NUM) {
            return -1;
        }
        String curNum = Integer.toString(n);
        if (n == KEPLER_NUM) {
            return steps;
        }
        int[] masOfNums = new int[curNum.length()];
        for (int i = 0; i < curNum.length(); i++) {
            masOfNums[i] = curNum.charAt(i) - '0';
        }
        Arrays.sort(masOfNums);
        //безопасней
        String numStr =
            IntStream.of(masOfNums)
            .mapToObj(Integer::toString)
            .collect(Collectors.joining(""));
        int lowerNum = Integer.parseInt(numStr);
        int upperNum = Integer.parseInt(new StringBuffer(numStr).reverse().toString());
        int res = upperNum - lowerNum;
        return getKaprekerNum(res, steps + 1);
    }
}
