package edu.hw3;

import java.util.TreeMap;

@SuppressWarnings("checkstyle:MagicNumber") public final class Task4 {
    private Task4() {}

    private static final int MAX_VALUE_FOR_ROMAN_NUMBERS = 3999;

    private static final TreeMap<Integer, String> ROMAN_MAP = new TreeMap<>();

    static  {
        ROMAN_MAP.put(1000, "M");
        ROMAN_MAP.put(900, "CM");
        ROMAN_MAP.put(500, "D");
        ROMAN_MAP.put(400, "CD");
        ROMAN_MAP.put(100, "C");
        ROMAN_MAP.put(90, "XC");
        ROMAN_MAP.put(50, "L");
        ROMAN_MAP.put(40, "XL");
        ROMAN_MAP.put(10, "X");
        ROMAN_MAP.put(9, "IX");
        ROMAN_MAP.put(5, "V");
        ROMAN_MAP.put(4, "IV");
        ROMAN_MAP.put(1, "I");
    }

    public static String convertToRoman(int elem) {
        if (elem > MAX_VALUE_FOR_ROMAN_NUMBERS) {
            throw new IllegalArgumentException("Number cant be bigger then 3999");
        }

        int max = ROMAN_MAP.floorKey(elem);
        if (max == elem) {
            return ROMAN_MAP.get(elem);
        }
        return ROMAN_MAP.get(max) + convertToRoman(elem - max);
    }
}
