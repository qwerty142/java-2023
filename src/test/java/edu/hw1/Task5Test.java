package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    // Given
    static Arguments[] Tests() {
        return new Arguments[] {
            Arguments.of(363, true), // is palindrom
            Arguments.of(5234, true), // 5234 -> 77
            Arguments.of(1234, false), // 1234 -> 37 -> 10 -> 1
            Arguments.of(1, false), // 1
            Arguments.of(-363, true), // -363 -> 363
            Arguments.of(-5234, true), // -5234 -> 5234 -> 77
            Arguments.of(11211230, true), // 11211230 -> 2333 -> 56 -> 11
            Arguments.of(13001120, true), // 12001120 -> 4022 -> 44
            Arguments.of(23336014, true), // 23336014 -> 5665
            Arguments.of(11, true)
        };
    }

    @DisplayName("Проверка на особый палиндром")
    @ParameterizedTest
    @MethodSource("Tests")
    public void isPalindromeDescendant_shouldReturnAbilityOfConvertingNumToPalindrom(int num, boolean result) {
        // When
        boolean abilityOfConverting = Task5.isPalindromeDescendant(num);
        // Then
        assertThat(abilityOfConverting).isEqualTo(result);
    }
}
