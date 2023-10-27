package edu.hw3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class Task1 {
    private Task1() {}

    @SuppressWarnings("checkstyle:OneStatementPerLine") private static void fillMap(Map<Character, Character> map) {
        map.put('A', 'Z'); map.put('a', 'z'); map.put('b', 'y'); map.put('B', 'Y');
        map.put('c', 'x'); map.put('C', 'X'); map.put('d', 'w'); map.put('D', 'W');
        map.put('e', 'v'); map.put('E', 'V'); map.put('f', 'u'); map.put('F', 'U');
        map.put('g', 't'); map.put('G', 'T'); map.put('h', 's'); map.put('H', 'S');
        map.put('i', 'r'); map.put('I', 'R'); map.put('j', 'q'); map.put('J', 'Q');
        map.put('k', 'p'); map.put('K', 'P'); map.put('l', 'o'); map.put('L', 'O');
        map.put('m', 'n'); map.put('M', 'N'); map.put('Z', 'A'); map.put('z', 'a');
        map.put('y', 'b'); map.put('Y', 'B'); map.put('x', 'c'); map.put('X', 'C');
        map.put('w', 'd'); map.put('W', 'D'); map.put('v', 'e'); map.put('V', 'E');
        map.put('u', 'f'); map.put('U', 'F'); map.put('t', 'g'); map.put('T', 'G');
        map.put('s', 'h'); map.put('S', 'H'); map.put('r', 'i'); map.put('R', 'I');
        map.put('q', 'j'); map.put('Q', 'J'); map.put('p', 'k'); map.put('P', 'K');
        map.put('o', 'l'); map.put('O', 'L'); map.put('n', 'm'); map.put('N', 'M');
    }

    public static String atbash(String input) {
        StringBuilder stringBuilder = new StringBuilder(input);
        Map<Character, Character> comparisonMap = new HashMap<>();
        fillMap(comparisonMap);

        for (int i = 0; i < stringBuilder.length(); i++) {
            if (comparisonMap.containsKey(stringBuilder.charAt(i))) {
                stringBuilder.setCharAt(i, comparisonMap.get(stringBuilder.charAt(i)));
            }
        }

        return stringBuilder.toString();
    }
}
