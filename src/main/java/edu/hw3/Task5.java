package edu.hw3;

import java.util.Comparator;
import java.util.List;

public final class Task5 {
    private Task5() {}

    public static List<String> parseContacts(List<String> names, String order) {
        if (order == null) {
            throw new NullPointerException("order cant be null");
        }
        if (names == null) {
            return List.of();
        }

        if (order.equals("ASC")) {
            return names.stream().sorted(new StringComparatorNaturalOrder()).toList();
        }
        if (order.equals("DESC")) {
            return names.stream().sorted(new StringComparatorReversOrder()).toList();
        }
        return null;
    }

    private static final class StringComparatorNaturalOrder implements Comparator<String> {

        @SuppressWarnings("checkstyle:ReturnCount")
        @Override
        public int compare(String o1, String o2) {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return -1;
            }
            if (o2 == null) {
                return 1;
            }
            String[] o1Parts = o1.split(" ");
            String[] o2Parts = o2.split(" ");
            if (o1Parts.length < 2 || o2Parts.length < 2) {
                return o1Parts[0].compareTo(o2Parts[0]);
            }
            return o1Parts[1].compareTo(o2Parts[1]);
        }
    }

    private static final class StringComparatorReversOrder implements Comparator<String> {

        @SuppressWarnings("checkstyle:ReturnCount")
        @Override
        public int compare(String o2, String o1) {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return -1;
            }
            if (o2 == null) {
                return 1;
            }
            String[] o1Parts = o1.split(" ");
            String[] o2Parts = o2.split(" ");
            if (o1Parts.length < 2 || o2Parts.length < 2) {
                return o1Parts[0].compareTo(o2Parts[0]);
            }
            return o1Parts[1].compareTo(o2Parts[1]);
        }
    }
}
