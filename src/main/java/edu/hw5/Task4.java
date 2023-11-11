package edu.hw5;

import java.util.regex.Pattern;

public final class Task4 {
    private Task4() {}

    private static Pattern inputPattern = Pattern.compile("[~!@#$%^&*|]");

    public static boolean checkPassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException();
        }
        return inputPattern.matcher(password).find();
    }
}
