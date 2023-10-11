package edu.hw1;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task6 {
    private Task6() {
    }

    public static int get_Kepler(int num, int steps) {
        if (num < 1000) {
            return -1;
        }
        String cur_num = Integer.toString(num);

        if (num == 6174) {
            return steps;
        }
        int[] mas_of_nums = new int[cur_num.length()];
        for (int i = 0; i < cur_num.length(); ++i) {
            mas_of_nums[i] = cur_num.charAt(i) - '0';
        }
        Arrays.sort(mas_of_nums);
        String num_str = IntStream.of(mas_of_nums).mapToObj(Integer::toString).collect(Collectors.joining(""));
        int lower_num = Integer.parseInt(num_str);
        int upper_num = Integer.parseInt(new StringBuffer(num_str).reverse().toString());
        int res = upper_num - lower_num;
        return get_Kepler(res, steps + 1);
    }
}
