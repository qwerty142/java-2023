package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTaskFive {
    static Arguments[] Tests() {
        return new Arguments[] {
            Arguments.of(363, true),
            Arguments.of(5234, true),
            Arguments.of(1234, false),
            Arguments.of(1, false),
            Arguments.of(-363, true),
            Arguments.of(-5234, true),
            Arguments.of(11211230, true),
            Arguments.of(13001120, true),
            Arguments.of(23336014, true)
        };
    }

    @DisplayName("Проверка на особый палиндром")
    @ParameterizedTest
    @MethodSource("Tests")
    public void CheckTask5(int num, boolean result) {
        assertThat(Task5.isPalindromeDescendant(num)).isEqualTo(result);
    }
}
