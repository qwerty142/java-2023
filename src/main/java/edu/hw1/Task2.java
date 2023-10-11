package edu.hw1;

import static edu.hw1.Constants.Step;

public class Task2 {
    private Task2() {
    }

    public static int countDigits(int digit) {
        int newDigit = Math.abs(digit);
        int res = 0;
        do {
            newDigit /= Step;
            res += 1;
        } while (newDigit > 0);
        return res;

    }
}
