package edu.hw1;

public class Task3 {
    private Task3() {
    }

    public static boolean check_array_on_nesting(int[] first_array, int[] second_array) {
        if (first_array.length == 0) {
            return second_array.length != 0;
        } else if (second_array.length == 0) {
            return false;
        }
        int minimum_first_array = Integer.MAX_VALUE;
        int maximum_first_array = Integer.MIN_VALUE;

        for (int elem : first_array) {
            if (elem <= minimum_first_array) {
                minimum_first_array = elem;
            }
            if (elem >= maximum_first_array) {
                maximum_first_array = elem;
            }
        }
        boolean availability_of_min = false;
        boolean availability_of_max = false;
        for (int elem : second_array) {
            if (elem < minimum_first_array) {
                availability_of_min = true;
            }
            if (elem > maximum_first_array) {
                availability_of_max = true;
            }
            if (availability_of_min && availability_of_max) {
                break;
            }
        }
        return availability_of_min && availability_of_max;
    }
}
