package edu.hw1;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task6 {
    private Task6() {
    }

    public static int getKepler(int num, int steps) {
        int minNum = 1000;
        int finalRes = 6174;
        if (num < minNum) {
            return -1;
        }
        String curNum = Integer.toString(num);

        if (num == finalRes) {
            return steps;
        }
        int[] masOfNums = new int[curNum.length()];
        for (int i = 0; i < curNum.length(); ++i) {
            masOfNums[i] = curNum.charAt(i) - '0';
        }
        Arrays.sort(masOfNums);
        String numStr = IntStream.of(masOfNums).mapToObj(Integer::toString).collect(Collectors.joining(""));
        int lowerNum = Integer.parseInt(numStr);
        int upperNum = Integer.parseInt(new StringBuffer(numStr).reverse().toString());
        int res = upperNum - lowerNum;
        return getKepler(res, steps + 1);
    }
}
