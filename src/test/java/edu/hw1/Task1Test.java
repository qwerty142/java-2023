package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    //Given
    // По поводу 0:59 не должно возвращать -1, так как в задании сказано
    static Arguments[] Tests() {
        return new Arguments[] {
            Arguments.of("01:00", 60),
            Arguments.of("13:56", 836),
            Arguments.of("10:10", 610),
            Arguments.of("00:00", 0),
            Arguments.of("100:40", 6040),
            Arguments.of("00: 78", -1),
            Arguments.of("abc:df", -1),
            Arguments.of("1256", -1),
            Arguments.of("10:60", -1)
            };
    }
    @DisplayName("Общая длина видео в секундах")
    @ParameterizedTest
    @MethodSource("Tests")
    void minutesToSeconds_shouldConvertIfToSecondsWithStandardValue(String input, int result) {
        //When
        int AmountOfSeconds = Task1.minutesToSeconds(input);
        //Then
        assertThat(AmountOfSeconds).isEqualTo(result);
    }
}
