package edu.hw1;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static edu.hw1.Constants.FinalRes;
import static edu.hw1.Constants.MinNumVal;

public class Task6 {
    private Task6() {
    }

    public static int getKepler(int num, int steps) {
        if (num < MinNumVal) {
            return -1;
        }
        String curNum = Integer.toString(num);

        if (num == FinalRes) {
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
