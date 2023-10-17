package edu.hw1;

public final class Task2 {
    private Task2() {
    }

    public static final int STEP = 10;

    public static int countDigits(int digit) {
        int newDigit = Math.abs(digit);
        int res = 0;
        do {
            newDigit /= STEP;
            res += 1;
        } while (newDigit > 0);
        return res;

    }
}
