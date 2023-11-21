package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task6 {
    private Task6() {}

    public static boolean checkOnSubString(String sub, String string) {
        Pattern pattern = Pattern.compile(sub);
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }
}
