package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class Task8Test {
    // 1 task
    static Stream<Arguments> CorrectArgsFor1Task() {
        // odd length
        return Stream.of(
            Arguments.of("0"),
            Arguments.of("1"),
            Arguments.of("111"),
            Arguments.of("000"),
            Arguments.of("101"),
            Arguments.of("010"),
            Arguments.of("1010101010101")
        );
    }

    @ParameterizedTest
    @MethodSource("CorrectArgsFor1Task")
    public void TestCorrectTask1(String string) {
        assertThat(Task8.mathOddLength(string)).isTrue();
    }

    static Stream<Arguments> IncorrectArgsFor1Task() {
        // odd length
        return Stream.of(
            Arguments.of(""),
            Arguments.of("11"),
            Arguments.of("123"),
            Arguments.of("0000"),
            Arguments.of("qwee")
        );
    }

    @ParameterizedTest
    @MethodSource("IncorrectArgsFor1Task")
    public void TestIncorrectTask1(String string) {
        assertThat(Task8.mathOddLength(string)).isFalse();
    }

    // Task 2

    static Stream<Arguments> CorrectArgsFor2Task() {
        // start 0 and odd length or start 1 and even length
        return Stream.of(
            Arguments.of("0"),
            Arguments.of("11"),
            Arguments.of("1110"),
            Arguments.of("000"),
            Arguments.of("1011"),
            Arguments.of("010"),
            Arguments.of("10101010101011")
        );
    }

    @ParameterizedTest
    @MethodSource("CorrectArgsFor2Task")
    public void TestCorrectTask2(String string) {
        assertThat(Task8.mathStarts0AndHasOddLengthOrStarts1AndHasEvenLength(string)).isTrue();
    }

    static Stream<Arguments> IncorrectArgsFor2Task() {
        // start 0 and odd length or start 1 and even length
        return Stream.of(
            Arguments.of(""),
            Arguments.of("111"),
            Arguments.of("123"),
            Arguments.of("0000"),
            Arguments.of("qwee")
        );
    }

    @ParameterizedTest
    @MethodSource("IncorrectArgsFor2Task")
    public void TestIncorrectTask2(String string) {
        assertThat(Task8.mathStarts0AndHasOddLengthOrStarts1AndHasEvenLength(string)).isFalse();
    }

    // Task 3

    static Stream<Arguments> CorrectArgsFor3Task() {
        // amount of 3 is divided by 3
        return Stream.of(
            Arguments.of("111"),
            Arguments.of("1"),
            Arguments.of("000"),
            Arguments.of("01010111"),
            Arguments.of("101010101010"),
            Arguments.of("0100")
        );
    }

    @ParameterizedTest
    @MethodSource("CorrectArgsFor3Task")
    public void TestCorrectTask3(String string) {
        assertThat(Task8.mathTheNumberOfZerosMultipleThree(string)).isTrue();
    }

    static Stream<Arguments> IncorrectArgsFor3Task() {
        // amount of 3 is divided by 3
        return Stream.of(
            Arguments.of("0"),
            Arguments.of("101"),
            Arguments.of("1001"),
            Arguments.of("123"),
            Arguments.of("0000"),
            Arguments.of("qwee")
        );
    }

    @ParameterizedTest
    @MethodSource("IncorrectArgsFor3Task")
    public void TestIncorrectTask3(String string) {
        assertThat(Task8.mathTheNumberOfZerosMultipleThree(string)).isFalse();
    }

    // Task4

    static Stream<Arguments> CorrectArgsFor4Task() {
        // any string except 11 and 111
        return Stream.of(
            Arguments.of(""),
            Arguments.of("0"),
            Arguments.of("1"),
            Arguments.of("101"),
            Arguments.of("000"),
            Arguments.of("101"),
            Arguments.of("010"),
            Arguments.of("1010101010101")
        );
    }

    @ParameterizedTest
    @MethodSource("CorrectArgsFor4Task")
    public void TestCorrectTask4(String string) {
        assertThat(Task8.mathAnyStringExcept11And111(string)).isTrue();
    }

    static Stream<Arguments> IncorrectArgsFor4Task() {
        // any string except 11 and 111
        return Stream.of(
            Arguments.of("11"),
            Arguments.of("111"),
            Arguments.of("123"),
            Arguments.of("qwee")
        );
    }

    @ParameterizedTest
    @MethodSource("IncorrectArgsFor4Task")
    public void TestIncorrectTask4(String string) {
        assertThat(Task8.mathAnyStringExcept11And111(string)).isFalse();
    }

    // Task 5

    static Stream<Arguments> CorrectArgsFor5Task() {
        // any odd symbol is 1
        return Stream.of(
            Arguments.of(""),
            Arguments.of("1"),
            Arguments.of("101"),
            Arguments.of("111"),
            Arguments.of("1010101010101")
        );
    }

    @ParameterizedTest
    @MethodSource("CorrectArgsFor5Task")
    public void TestCorrectTask5(String string) {
        assertThat(Task8.mathAnyOddNumberIsOne(string)).isTrue();
    }

    static Stream<Arguments> IncorrectArgsFor5Task() {
        // any odd symbol is 1
        return Stream.of(
            Arguments.of("0"),
            Arguments.of("110"),
            Arguments.of("123"),
            Arguments.of("0000"),
            Arguments.of("qwee")
        );
    }

    @ParameterizedTest
    @MethodSource("IncorrectArgsFor5Task")
    public void TestIncorrectTask5(String string) {
        assertThat(Task8.mathAnyOddNumberIsOne(string)).isFalse();
    }
}
