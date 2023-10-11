package edu.hw1;

public class Task4 {
    private Task4() {
    }

    public static String fixString(String inputString) {
        if (inputString == null) {
            return "";
        }
        char[] fixedString = inputString.toCharArray();

        for (int i = 1; i < inputString.length(); i += 2) {
            char c = fixedString[i - 1];
            fixedString[i - 1] = fixedString[i];
            fixedString[i] = c;
        }

        return String.valueOf(fixedString);
    }
}
