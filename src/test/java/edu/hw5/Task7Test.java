package edu.hw5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
public class Task7Test {
    // AtLeast3CharactersThirdCharacter0
    @Test
    public void CorrectAtLeast3CharactersThirdCharacter0() {
        String string = "1101";

        assertThat(Task7.atLeast3CharactersThirdCharacter0(string)).isTrue();
    }
    static Stream<Arguments> IncorrectAtLeast3CharactersThirdCharacter0() {
        return Stream.of(
            Arguments.of(""),
            Arguments.of(" "),
            Arguments.of("qw"),
            Arguments.of("qwe"),
            Arguments.of("qwert"),
            Arguments.of("0"),
            Arguments.of("111"),
            Arguments.of("1111")

        );
    }

    @ParameterizedTest
    @MethodSource("IncorrectAtLeast3CharactersThirdCharacter0")
    public void TestIncorrectAtLeast3CharactersThirdCharacter0(String string) {
        assertThat(Task7.atLeast3CharactersThirdCharacter0(string)).isFalse();
    }

    // StartEndWithSameSymbol

    @ParameterizedTest
    @ValueSource(strings = {"0", "1101", "11"})
    public void CorrectStartEndWithSameSymbol(String string) {

        assertThat(Task7.startsAndEndsWithSameCharacter(string)).isTrue();
    }
    static Stream<Arguments> IncorrectStartEndWithSameSymbol() {
        return Stream.of(
            Arguments.of(""),
            Arguments.of("qq"),
            Arguments.of("qwq"),
            Arguments.of("011"),
            Arguments.of("1100"),
            Arguments.of("1234")

        );
    }

    @ParameterizedTest
    @MethodSource("IncorrectStartEndWithSameSymbol")
    public void TestIncorrectStartEndWithSameSymbol(String string) {
        assertThat(Task7.startsAndEndsWithSameCharacter(string)).isFalse();
    }

    // lengthNoLessThan1AndNoMoreThan3

    @ParameterizedTest
    @ValueSource(strings = {"0", "11", "111"})
    public void CorrectLengthNoLessThan1AndNoMoreThan3(String string) {

        assertThat(Task7.lengthNoLessThan1AndNoMoreThan3(string)).isTrue();
    }
    static Stream<Arguments> IncorrectLengthNoLessThan1AndNoMoreThan3() {
        return Stream.of(
            Arguments.of(""),
            Arguments.of("qq"),
            Arguments.of("qwq"),
            Arguments.of("0111"),
            Arguments.of("11001"),
            Arguments.of("123")

        );
    }

    @ParameterizedTest
    @MethodSource("IncorrectLengthNoLessThan1AndNoMoreThan3")
    public void TestIncorrectLengthNoLessThan1AndNoMoreThan3(String string) {
        assertThat(Task7.lengthNoLessThan1AndNoMoreThan3(string)).isFalse();
    }
}
