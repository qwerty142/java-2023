package edu.hw1;

public class Task5 {
    private Task5() {
    }

    public static boolean isPalindromeDescendant(int num) {
        num = Math.abs(num);
        if (num < 10) {
            return false;
        }
        StringBuilder cur_num = new StringBuilder(Integer.toString(num));

        boolean first_check = true;
        for (int i = 0; i < cur_num.length() / 2; ++i) {
            if (cur_num.charAt(i) != cur_num.charAt(cur_num.length() - 1 - i)) {
                first_check = false;
                break;
            }
        }
        if (first_check) {
            return true;
        }

        int new_num = 0;
        boolean res = false;
        if (cur_num.length() % 2 == 1) {
            cur_num.append('0');
        }
        while (num > 9) {
            new_num = 0;
            if (cur_num.length() % 2 == 1) {
                cur_num.append('0');
            }
            for (int i = 1; i < cur_num.length(); i += 2) {
                int cur_part = (cur_num.charAt(i) - '0') + (cur_num.charAt(i - 1) - '0');
                if (cur_part >= 10) {
                    new_num *= 100;
                    new_num += cur_part;
                } else {
                    new_num *= 10;
                    new_num += cur_part;
                }
            }
            String check_string = Integer.toString(new_num);
            boolean check = true;
            for (int i = 0; i < check_string.length() / 2; ++i) {
                if (check_string.charAt(i) != check_string.charAt(check_string.length() - 1 - i)) {
                    check = false;
                    break;
                }
            }
            if (check && new_num > 9) {
                res = true;
                break;
            }
            cur_num = new StringBuilder(check_string);
            num = new_num;
        }
        return res;
    }
}
