package edu.hw5;

import java.util.regex.Pattern;

public final class Task8 {
    private Task8() {}

    private static final Pattern PATTERN1 = Pattern.compile("([10][10])*[10]$");
    private static final Pattern PATTERN2 = Pattern.compile("(^[0]([10][10])*$)|(^[1]([10][10])*[10]$)");
    private static final Pattern PATTERN3 = Pattern.compile("(^1*$)|(^(1*01*01*01*)*$)");
    private static final Pattern PATTERN4 = Pattern.compile("(?!(^11$|^111$))(^[10]*$)");
    private static final Pattern PATTERN5 = Pattern.compile("^(1[10])*[1]?$");

    public static boolean mathOddLength(String string) {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        return PATTERN1.matcher(string).matches();
    }

    public static boolean mathStarts0AndHasOddLengthOrStarts1AndHasEvenLength(String string) {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        return PATTERN2.matcher(string).matches();
    }

    public static boolean mathTheNumberOfZerosMultipleThree(String string) {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        return PATTERN3.matcher(string).matches();
    }

    public static boolean mathAnyStringExcept11And111(String string) {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        return PATTERN4.matcher(string).matches();
    }

    public static boolean mathAnyOddNumberIsOne(String string) {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        return PATTERN5.matcher(string).matches();
    }
}
