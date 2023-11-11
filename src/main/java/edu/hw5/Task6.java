package edu.hw5;

import java.util.regex.Pattern;

public final class Task6 {
    private Task6() {}

    public static boolean checkOnSubString(String sub, String string) {
        if (sub == null || string == null) {
            throw new NullPointerException();
        }
        Pattern pattern = Pattern.compile(sub);
        return pattern.matcher(string).find();
    }
}
