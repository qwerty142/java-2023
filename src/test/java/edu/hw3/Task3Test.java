package edu.hw3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
public class Task3Test {
    // Given
    static Stream<Arguments> freqDict() {
        return Stream.of(
            Arguments.of(
               List.of( "a", "bb", "a", "bb" ),
                Map.of("bb", 2, "a", 2)
            ),
            Arguments.of(List.of("this", "and", "that", "and"), Map.of("that", 1, "and", 2, "this", 1)),
            Arguments.of(List.of("this", "and", "that", "and"), Map.of("that", 1, "and", 2, "this", 1)),
            Arguments.of(List.of("код", "код", "код", "код","bug"), Map.of("код", 4, "bug", 1)),
            Arguments.of(List.of(1, 1, 2, 2), Map.of(1, 2, 2, 2))
        );
    }
    @ParameterizedTest
    @MethodSource("freqDict")
    public<T> void freqDictTest(List<T> input, Map<T, Integer> expectedResult) {
        // When
        Map<T,Integer> result = Task3.freqDict(input);
        // Then
        assertThat(result).isEqualTo(expectedResult);
    }
}
