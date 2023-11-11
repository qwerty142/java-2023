package edu.hw5;

import java.util.regex.Pattern;

@SuppressWarnings("checkstyle:LineLength") public final class Task5 {
    private Task5() {}

    private static final Pattern INPUT_PATTERN = Pattern.compile("[ABCEHKMOPTXY]\\d{3}[ABCEHKMOPTXY]{2}(\\d{2}|[179]\\d{2})");

    public static boolean isValidCarNumber(String number) {
        if (number == null) {
            throw new NullPointerException();
        }
        return INPUT_PATTERN.matcher(number).matches();
    }
}
