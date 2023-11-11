package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task1Test {
    private static Stream<Arguments> Task1Arguments() {
        return Stream.of(
            Arguments.of(
                List.of("2022-03-12, 20:20 - 2022-03-12, 23:50",
                    "2022-04-01, 21:30 - 2022-04-02, 01:20"),
                "PT3H40M"
            ),
            Arguments.of(
                List.of("2022-03-12, 20:10 - 2022-03-12, 23:50",
                    "2022-04-01, 21:30 - 2022-04-02, 01:20"),
                "PT3H45M"
            ),
            Arguments.of( // отрицательное
                List.of("2022-03-12, 20:10 - 2022-03-12, 20:00",
                    "2022-04-01, 21:30 - 2022-04-01, 21:20"),
                "PT-10M"
            )
        );
    }
    @ParameterizedTest
    @MethodSource("Task1Arguments")
    public void ShouldReturnMediumValue(List<String> arguments, String result) {
        assertThat(Task1.countTime(arguments)).isEqualTo(result);
    }

    private static Stream<Arguments> Task1ArgumentsFail() {
        return Stream.of(
            Arguments.of( // no "-" after 2022
                List.of("202203-12, 20:20 - 2022-03-12, 23:50",
                    "2022-04-01, 21:30 - 2022-04-02, 01:20")
            ),
            Arguments.of( // no ":" after 20
                List.of("2022-03-12, 2010 - 2022-03-12, 23:50",
                    "2022-04-01, 21:30 - 2022-04-02, 01:20")
            ),
            Arguments.of( // no "," after 03-12
                List.of("2022-03-12, 20:10 - 2022-03-12 20:00",
                    "2022-04-01, 21:30 - 2022-04-01, 21:20")
            )
        );
    }

    @ParameterizedTest
    @MethodSource("Task1ArgumentsFail")
    public void TestFail(List<String> arguments) {
        assertThrows(IllegalArgumentException.class, () -> Task1.countTime(arguments));
    }

}
