package edu.hw3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Vector;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class Task8Test {
    static Stream<Arguments> ReverseIterator() {
        return Stream.of(
            Arguments.of(new ArrayList<Integer>()),
            Arguments.of(new Vector<Integer>()),
            Arguments.of(new LinkedList<Integer>()),
            Arguments.of(new TreeSet<Integer>()),
            Arguments.of(new ArrayDeque<Integer>())
        );
    }
    @ParameterizedTest
    @MethodSource("ReverseIterator")
    public void ReverseIteratorTest(Collection<Integer> input) {
        input.add(10);
        input.add(20);
        input.add(30);

        var reverseIterator = new Task8.ReverseIterator(input);

        assertThat(reverseIterator.hasNext()).isTrue();
        assertThat(reverseIterator.next()).isEqualTo(30);
        assertThat(reverseIterator.next()).isEqualTo(20);
        assertThat(reverseIterator.next()).isEqualTo(10);
        assertThat(reverseIterator.hasNext()).isFalse();
    }
}
