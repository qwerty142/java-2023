package edu.hw5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class Task2Test {
    @Test
    public void TestNextFriday() {
        LocalDate date = LocalDate.of(2023, 1, 1);
        LocalDate expect = LocalDate.of(2023, 1, 13);

        LocalDate nextFriday = Task2.getNextFriday(date);

        assertThat(nextFriday).isEqualTo(expect);
    }

    static Stream<Arguments> ArgsStandardTest() {
        return Stream.of(
            Arguments.of(1900),
            Arguments.of(1985),
            Arguments.of(2001)
        );
    }

    @ParameterizedTest
    @MethodSource("ArgsStandardTest")
    public void StandardTest(int year) {
        List<LocalDate> res = Task2.getAllFridays(year);

        for(var elem : res) {
            assertThat(elem.getDayOfMonth()).isEqualTo(13);
            assertThat(elem.getYear()).isEqualTo(year);
            assertThat(elem.getDayOfWeek()).isEqualTo(DayOfWeek.FRIDAY);
        }
    }
}
