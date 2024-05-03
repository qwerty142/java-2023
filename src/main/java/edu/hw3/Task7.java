package edu.hw3;

import java.util.Comparator;

public final class Task7 {
    private Task7() {}

    public static class NullFriendlyComparator<T extends Comparable<T>> implements Comparator<T> {

        @Override
        public int compare(T o1, T o2) {
            if (o1 == null && o2 == null) {
                return 0; // equal
            }
            if (o1 == null) {
                return -1; // less
            }
            if (o2 == null) {
                return 1; // more
            }
            return o1.compareTo(o2);
        }
    }
}
