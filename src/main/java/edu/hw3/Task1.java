package edu.hw3;

import java.util.HashMap;
import java.util.Map;

public final class Task1 {
    private Task1() {}

    private static Map<Character, Character> comparisonMap = new HashMap<>();
    private static StringBuilder stringBuilder;

    static {
        for (Character i = 'A'; i <= 'Z'; i++) {
            comparisonMap.put(i, (char) ('Z' - (i - 'A')));
        }

        for (Character i = 'a'; i <= 'z'; i++) {
            comparisonMap.put(i, (char) ('z' - (i - 'a')));
        }
    }

    public static String atbash(String input) {

        stringBuilder = new StringBuilder(input);
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (comparisonMap.containsKey(stringBuilder.charAt(i))) {
                stringBuilder.setCharAt(i, comparisonMap.get(stringBuilder.charAt(i)));
            }
        }

        return stringBuilder.toString();
    }
}
