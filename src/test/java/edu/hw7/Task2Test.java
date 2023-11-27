package edu.hw7;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    static Stream<Arguments> Task2Args() {
        return Stream.of(
            Arguments.of(6, 720L),
            Arguments.of(1, 1L),
            Arguments.of(0, 1L),
            Arguments.of(2, 2L),
            Arguments.of(4, 24L)
        );
    }

    @ParameterizedTest
    @MethodSource("Task2Args")
    public void ShouldReturnFactorial(int num, Long result) {
        assertThat(Task2.getFactorial(num)).isEqualTo(result);
    }
}
