package edu.hw1;

public class Task2 {
    private Task2() {
    }

    public static int countDigits(int digit) {
        int newDigit = Math.abs(digit);
        int res = 0;
        int step = 10;
        do {
            newDigit /= step;
            res += 1;
        } while (newDigit > 0);
        return res;

    }
}
