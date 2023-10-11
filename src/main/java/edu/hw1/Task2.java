package edu.hw1;

public class Task2 {
    private Task2(){}
    public static int countDigits(int digit){
        int new_digit = Math.abs(digit);
        int res = 0;
        do{
            new_digit/=10;
            res += 1;
        } while(new_digit > 0);
        return res;

    }
}
