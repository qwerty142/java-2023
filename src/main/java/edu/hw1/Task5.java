package edu.hw1;

public class Task5 {
    private Task5() {
    }

    public static boolean isPalindromeDescendant(int num) {
        num = Math.abs(num);
        int minNum = 10;
        if (num < minNum) {
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
        while (num > 9) {
            newNum = 0;
            if (curNum.length() % 2 == 1) {
                curNum.append('0');
            }
            for (int i = 1; i < curNum.length(); i += 2) {
                int curPart = (curNum.charAt(i) - '0') + (curNum.charAt(i - 1) - '0');
                if (curPart >= 10) {
                    newNum *= 100;
                    newNum += curPart;
                } else {
                    newNum *= 10;
                    newNum += curPart;
                }
            }
            String checkString = Integer.toString(newNum);
            boolean check = true;
            for (int i = 0; i < checkString.length() / 2; ++i) {
                if (checkString.charAt(i) != checkString.charAt(checkString.length() - 1 - i)) {
                    check = false;
                    break;
                }
            }
            if (check && newNum > 9) {
                res = true;
                break;
            }
            curNum = new StringBuilder(checkString);
            num = newNum;
        }
        return res;
    }
}
