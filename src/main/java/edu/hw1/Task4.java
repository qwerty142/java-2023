package edu.hw1;

import java.util.Arrays;

public class Task4 {
    private Task4(){}

    public static String fixString(String input_string){
        if(input_string == null){
            return "";
        }
        char[] fixed_string = input_string.toCharArray();

        for(int i = 1; i < input_string.length(); i+=2){
            char c = fixed_string[i-1];
            fixed_string[i - 1] = fixed_string[i];
            fixed_string[i] = c;
        }
        /*if(input_string.length() > 1 && (input_string.length() % 2 == 1)){
            fixed_string[input_string.length() - 1] = input_string.charAt(input_string.length() - 1);
        }*/
        return String.valueOf(fixed_string);
    }
}
