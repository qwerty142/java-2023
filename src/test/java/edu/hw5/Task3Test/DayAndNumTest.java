package edu.hw5.Task3Test;

import edu.hw5.Task3;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class DayAndNumTest {
    static Stream<Arguments> CorrectDate() {
        return Stream.of(
            Arguments.of("1 days ago", Optional.of(LocalDate.now().minusDays(1))),
            Arguments.of("2234 days ago", Optional.of(LocalDate.now().minusDays(2234))),
            Arguments.of("1 months ago", Optional.of(LocalDate.now().minusMonths(1))),
            Arguments.of("1 years ago", Optional.of(LocalDate.now().minusYears(1))),
            Arguments.of("1 days after", Optional.of(LocalDate.now().plusDays(1))),
            Arguments.of("1 months after", Optional.of(LocalDate.now().plusMonths(1)))
        );
    }

    @ParameterizedTest
    @MethodSource("CorrectDate")
    public void TestDayAndNum(String date, Optional<LocalDate> expect) {
        assertThat(Task3.parseDate(date)).isEqualTo(expect);
    }

    static Stream<Arguments> IncorrectDate() {
        return Stream.of(
            Arguments.of("days ago", Optional.empty()),
            Arguments.of("1days ago", Optional.empty()),
            Arguments.of("1 daysago", Optional.empty()),
            Arguments.of("1daysago", Optional.empty()),
            Arguments.of("days 1 ago", Optional.empty())
        );
    }

    @ParameterizedTest
    @MethodSource("IncorrectDate")
    public void TestIncorrectDayAndNum(String date, Optional<LocalDate> expect) {
        assertThat(Task3.parseDate(date)).isEqualTo(expect);
    }
}
