package edu.hw5.Task3Test;

import edu.hw5.Task3;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class StandardDateTest {
    static Stream<Arguments> CorrectDate() {
        return Stream.of(
            Arguments.of("2020-10-1", Optional.of(LocalDate.of(2020, 10, 1))),
            Arguments.of("2020-12-02", Optional.of(LocalDate.of(2020, 12, 2))),
            Arguments.of("1000-01-01", Optional.of(LocalDate.of(1000, 1, 1))),
            Arguments.of("1-1-1", Optional.of(LocalDate.of(1, 1, 1)))
        );
    }

    @ParameterizedTest
    @MethodSource("CorrectDate")
    public void TestShortTypeDate(String date, Optional<LocalDate> expect) {
        assertThat(Task3.parseDate(date)).isEqualTo(expect);
    }

    static Stream<Arguments> IncorrectDate() {
        return Stream.of(
            Arguments.of("20000-1-1", Optional.empty()),
            Arguments.of("2000-123-1", Optional.empty()),
            Arguments.of("2000-1-123", Optional.empty()),
            Arguments.of("--", Optional.empty()),
            Arguments.of("", Optional.empty())
        );
    }

    @ParameterizedTest
    @MethodSource("IncorrectDate")
    public void TestIncorrectShortTypeDate(String date, Optional<LocalDate> expect) {
        assertThat(Task3.parseDate(date)).isEqualTo(expect);
    }
}
