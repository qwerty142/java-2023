package edu.hw1;

import static edu.hw1.Constants.MinNum;
import static edu.hw1.Constants.MinNumForWhile;
import static edu.hw1.Constants.OneStepUpper;
import static edu.hw1.Constants.TwoStepUpper;

public class Task5 {
    private Task5() {
    }

    public static boolean isPalindromeDescendant(int value) {
        int num = Math.abs(value);
        if (num < MinNum) {
            return false;
        }
        StringBuilder curNum = new StringBuilder(Integer.toString(num));

        boolean firstCheck = true;
        for (int i = 0; i < curNum.length() / 2; ++i) {
            if (curNum.charAt(i) != curNum.charAt(curNum.length() - 1 - i)) {
                firstCheck = false;
                break;
            }
        }
        if (firstCheck) {
            return true;
        }

        int newNum = 0;
        boolean res = false;
        if (curNum.length() % 2 == 1) {
            curNum.append('0');
        }
        while (num > MinNumForWhile) {
            newNum = 0;
            if (curNum.length() % 2 == 1) {
                curNum.append('0');
            }
            for (int i = 1; i < curNum.length(); i += 2) {
                int curPart = (curNum.charAt(i) - '0') + (curNum.charAt(i - 1) - '0');
                if (curPart >= MinNum) {
                    newNum *= TwoStepUpper;
                } else {
                    newNum *= OneStepUpper;
                }
                newNum += curPart;
            }
            String checkString = Integer.toString(newNum);
            boolean check = true;
            for (int i = 0; i < checkString.length() / 2; ++i) {
                if (checkString.charAt(i) != checkString.charAt(checkString.length() - 1 - i)) {
                    check = false;
                    break;
                }
            }
            if (check && newNum > MinNumForWhile) {
                res = true;
                break;
            }
            curNum = new StringBuilder(checkString);
            num = newNum;
        }
        return res;
    }
}
