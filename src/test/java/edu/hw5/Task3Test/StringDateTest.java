package edu.hw5.Task3Test;

import edu.hw5.Task3;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class StringDateTest {
    static Stream<Arguments> CorrectDate() {
        return Stream.of(
            Arguments.of("tomorrow", Optional.of(LocalDate.now().plusDays(1))),
            Arguments.of("today", Optional.of(LocalDate.now())),
            Arguments.of("yesterday", Optional.of(LocalDate.now().minusDays(1)))
        );
    }

    @ParameterizedTest
    @MethodSource("CorrectDate")
    public void TestShortTypeDate(String date, Optional<LocalDate> expect) {
        assertThat(Task3.parseDate(date)).isEqualTo(expect);
    }

    static Stream<Arguments> IncorrectDate() {
        return Stream.of(
            Arguments.of("omorrow", Optional.empty()),
            Arguments.of(" today", Optional.empty()),
            Arguments.of("yeste rday", Optional.empty()),
            Arguments.of("", Optional.empty())
        );
    }

    @ParameterizedTest
    @MethodSource("IncorrectDate")
    public void TestIncorrectShortTypeDate(String date, Optional<LocalDate> expect) {
        assertThat(Task3.parseDate(date)).isEqualTo(expect);
    }
}
