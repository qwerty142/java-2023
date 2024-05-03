package edu.hw3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {
    // Given
    static Stream<Arguments> convertToRoman() {
        return Stream.of(
            Arguments.of(2, "II"),
            Arguments.of(12, "XII"),
            Arguments.of(16, "XVI"),
            Arguments.of(110, "CX"),
            Arguments.of(600,  "DC"),
            Arguments.of(2222, "MMCCXXII")
        );
    }
    @ParameterizedTest
    @MethodSource("convertToRoman")
    public void convertToRomanTest(int input, String expectedResult) {
        // When
        String result = Task4.convertToRoman(input);
        // Then
        assertThat(result).isEqualTo(expectedResult);
    }
}
