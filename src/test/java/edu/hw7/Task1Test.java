package edu.hw7;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    static Stream<Arguments> Task1Args () {
        return Stream.of(
            Arguments.of(2, 4L),
            Arguments.of(3, 6L),
            Arguments.of(1, 2L),
            Arguments.of(10000, 20000L)
        );
    }

    @ParameterizedTest
    @MethodSource("Task1Args")
    public void ShouldReturnSumOfValueByTwoThreads(int amountOfAdd, Long result) {
        Task1 task1 = new Task1();
        assertThat(task1.countSumByThread(amountOfAdd)).isEqualTo(result);
    }
}
