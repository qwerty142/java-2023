package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    // Given
    static Arguments[] Tests() {
        return new Arguments[] {
            Arguments.of("123456", "214365"),
            Arguments.of("hTsii  s aimex dpus rtni.g", "This is a mixed up string."),
            Arguments.of("qwerty", "wqreyt"),
            Arguments.of("qwertyu", "wqreytu"),
            Arguments.of("qwertyu", "wqreytu"),
            Arguments.of("", ""),
            Arguments.of("q t y u i", " q t y ui"),
            Arguments.of("  ", "  "),
            Arguments.of("q", "q"),
            Arguments.of("a  i", " ai "),
            Arguments.of("ai", "ia")
        };
    }

    @DisplayName("Проверка строки с измененными местами символов")
    @ParameterizedTest
    @MethodSource("Tests")
    public void fixString_shouldReturnStringWithReverseOfEachPairOfSymbols(String input, String result) {
        // When
        String reversedString = Task4.fixString(input);
        // Then
        assertThat(reversedString).isEqualTo(result);
    }
}
