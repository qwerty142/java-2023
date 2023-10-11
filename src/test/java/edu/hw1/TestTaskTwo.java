package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTaskTwo {

    static Arguments[] Tests() {
        return new Arguments[] {Arguments.of(100, 3),
            Arguments.of(0, 1),
            Arguments.of(450654, 6),
            Arguments.of(-345, 3),
            Arguments.of(-1, 1),
            Arguments.of(9, 1)};
    }

    @DisplayName("Количество цифр в числе")
    @ParameterizedTest
    @MethodSource("Tests")
    void CheckTask2(int value, int result) {
        assertThat(Task2.countDigits(value)).isEqualTo(result);
    }
}
