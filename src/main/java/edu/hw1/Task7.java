package edu.hw1;

public class Task7 {
    private Task7() {
    }

    public static int leftRotate(int num, int shift) {
        int bit = Integer.toBinaryString(num).length();
        int realShift = shift % bit;

        return ((num << shift) | (num >> (bit - realShift))) & ((int) Math.pow(2, bit) - 1);
    }

    public static int rightRotate(int num, int shift) {
        int bit = Integer.toBinaryString(num).length();
        int realShift = shift % bit;
        return ((num >> shift) | (num << (bit - realShift))) & ((int) Math.pow(2, bit) - 1);
    }
}
