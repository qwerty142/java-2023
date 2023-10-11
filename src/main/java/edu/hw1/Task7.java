package edu.hw1;

import java.util.Arrays;

public class Task7 {
    private Task7(){}

    public static int left_rotate(int num, int shift){
        int bit = Integer.toBinaryString(num).length();
        int realShift = shift%bit;

        return ((num << shift) | (num >> (bit - realShift))) & ((int) Math.pow(2, bit) - 1) ;
    }
    public static int right_rotate(int num, int shift){
        int bit = Integer.toBinaryString(num).length();
        int realShift = shift%bit;
        return ((num >> shift) | (num << (bit - realShift))) & ((int)Math.pow(2,bit) - 1);
    }
}
