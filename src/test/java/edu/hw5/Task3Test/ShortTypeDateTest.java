package edu.hw5.Task3Test;

import edu.hw5.Task3;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class ShortTypeDateTest {
    static Stream<Arguments> CorrectDate() {
        return Stream.of(
            Arguments.of("1/3/1976", Optional.of(LocalDate.of(1976, 3, 1))),
            Arguments.of("1/3/20", Optional.of(LocalDate.of(20, 3, 1))),
            Arguments.of("1/10/2020", Optional.of(LocalDate.of(2020, 10, 1)))
        );
    }

    @ParameterizedTest
    @MethodSource("CorrectDate")
    public void TestShortTypeDate(String date, Optional<LocalDate> expect) {
        assertThat(Task3.parseDate(date)).isEqualTo(expect);
    }

    static Stream<Arguments> IncorrectDate() {
        return Stream.of(
            Arguments.of("13/1976", Optional.empty()),
            Arguments.of("999/1/1", Optional.empty()),
            Arguments.of("1/999/1", Optional.empty()),
            Arguments.of("//", Optional.empty())
        );
    }

    @ParameterizedTest
    @MethodSource("IncorrectDate")
    public void TestIncorrectShortTypeDate(String date, Optional<LocalDate> expect) {
        assertThat(Task3.parseDate(date)).isEqualTo(expect);
    }
}
