package edu.hw1;

import static edu.hw1.Constants.MAXSECONDS;
import static edu.hw1.Constants.SECONDSINMINUTE;

public final class Task1 {
    private Task1() {
    }

    public static int getSum(String s) {
        int result = 0;
        boolean indexOf = s.matches("\\d+:\\d\\d");
        if (!indexOf) {
            return -1;
        }
        String[] pos = s.split(":");
        if (Integer.parseInt(pos[1]) >= MAXSECONDS) {
            return -1;
        }
        result += Integer.parseInt(pos[0]) * SECONDSINMINUTE;
        result += Integer.parseInt(pos[1]);
        return result;
    }
}
