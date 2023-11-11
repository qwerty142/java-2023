package edu.hw5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task5Test {
    static Stream<Arguments> CorrectNumbers() {
        return Stream.of(
            Arguments.of("A123BE777"),
            Arguments.of("O777OO177"),
            Arguments.of("E987XE161"),
            Arguments.of("Y192CT919")
        );
    }

    @ParameterizedTest
    @MethodSource("CorrectNumbers")
    public void TestCorrectNumbers(String number) {
        assertThat(Task5.isValidCarNumber(number)).isTrue();
    }

    @Test
    public void TestNullInput() {
        assertThrows(IllegalArgumentException.class, () -> Task5.isValidCarNumber(null));
    }
}
