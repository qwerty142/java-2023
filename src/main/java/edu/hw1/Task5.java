package edu.hw1;


public final class Task5 {
    private Task5() {
    }

    public static final int MIN_NUM = 10;
    public static final int MIN_NUM_FOR_WHILE = 9;
    public static final int TWO_STEP_UPPER = 100;
    public static final int ONE_STEP_UPPER = 10;

    private static int createNewNum(StringBuilder curNum) {
        int newNum = 0;
        for (int i = 1; i < curNum.length(); i += 2) {
            int curPart = (curNum.charAt(i) - '0') + (curNum.charAt(i - 1) - '0');
            if (curPart >= MIN_NUM) {
                newNum *= TWO_STEP_UPPER;
            } else {
                newNum *= ONE_STEP_UPPER;
            }
            newNum += curPart;
        }
        return newNum;
    }

    private static boolean checkForPalindrom(StringBuilder curNum) {
        for (int i = 0; i < curNum.length() / 2; ++i) {
            if (curNum.charAt(i) != curNum.charAt(curNum.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkForPalindrom(String curNum) {
        for (int i = 0; i < curNum.length() / 2; ++i) {
            if (curNum.charAt(i) != curNum.charAt(curNum.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean finalCheckingForPalindrom(int num, StringBuilder curNum) {
        int newNum = 0;
        int n = num;
        StringBuilder numForThisFunction = curNum;
        while (n > MIN_NUM_FOR_WHILE) {
            newNum = 0;
            if (numForThisFunction.length() % 2 == 1) {
                numForThisFunction.append('0');
            }
            newNum = createNewNum(numForThisFunction);

            String checkString = Integer.toString(newNum);
            boolean check = checkForPalindrom(checkString);

            if (check && newNum > MIN_NUM_FOR_WHILE) {
                return true;
            }
            numForThisFunction = new StringBuilder(checkString);
            n = newNum;
        }
        return false;
    }

    public static boolean isPalindromeDescendant(int value) {
        int num = Math.abs(value);
        if (num < MIN_NUM) {
            return false;
        }
        StringBuilder curNum = new StringBuilder(Integer.toString(num));

        if (checkForPalindrom(curNum)) {
            return true;
        }

        int newNum = 0;
        if (curNum.length() % 2 == 1) {
            curNum.append('0');
        }

        return finalCheckingForPalindrom(num, curNum);
    }
}
