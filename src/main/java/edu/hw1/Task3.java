package edu.hw1;

public class Task3 {
    private Task3() {
    }

    public static boolean checkArrayOnNesting(int[] first_array, int[] second_array) {
        if (first_array.length == 0) {
            return second_array.length != 0;
        } else if (second_array.length == 0) {
            return false;
        }
        int minimumFirstArray = Integer.MAX_VALUE;
        int maximumFirstArray = Integer.MIN_VALUE;

        for (int elem : first_array) {
            if (elem <= minimumFirstArray) {
                minimumFirstArray = elem;
            }
            if (elem >= maximumFirstArray) {
                maximumFirstArray = elem;
            }
        }
        boolean availabilityOfMin = false;
        boolean availabilityOfMax = false;
        for (int elem : second_array) {
            if (elem < minimumFirstArray) {
                availabilityOfMin = true;
            }
            if (elem > minimumFirstArray) {
                availabilityOfMax = true;
            }
            if (availabilityOfMin && availabilityOfMax) {
                break;
            }
        }
        return availabilityOfMin && availabilityOfMax;
    }
}
