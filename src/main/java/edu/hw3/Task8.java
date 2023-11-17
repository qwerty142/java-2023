package edu.hw3;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public final class Task8 {
    private Task8() {}

    public static class ReverseIterator<T> implements Iterator<T> {

        private final ListIterator<T> reverseIterator;

        public ReverseIterator(Collection<T> collection) {
            reverseIterator = collection.stream().toList().listIterator(collection.size());
        }

        @Override
        public boolean hasNext() {
            return reverseIterator.hasPrevious();
        }

        @Override
        public T next() {
            return reverseIterator.previous();
        }
    }
}
