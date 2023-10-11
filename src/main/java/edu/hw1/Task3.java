package edu.hw1;

public class Task3 {
    private Task3() {
    }

    public static boolean checkArrayOnNesting(int[] firstArray, int[] secondArray) {
        if (firstArray.length == 0) {
            return secondArray.length != 0;
        } else if (secondArray.length == 0) {
            return false;
        }
        int minimumFirstArray = Integer.MAX_VALUE;
        int maximumFirstArray = Integer.MIN_VALUE;

        for (int elem : firstArray) {
            if (elem <= minimumFirstArray) {
                minimumFirstArray = elem;
            }
            if (elem >= maximumFirstArray) {
                maximumFirstArray = elem;
            }
        }
        boolean availabilityOfMin = false;
        boolean availabilityOfMax = false;
        for (int elem : secondArray) {
            if (elem < minimumFirstArray) {
                availabilityOfMin = true;
            }
            if (elem > maximumFirstArray) {
                availabilityOfMax = true;
            }
            if (availabilityOfMin && availabilityOfMax) {
                break;
            }
        }
        return availabilityOfMin && availabilityOfMax;
    }
}
