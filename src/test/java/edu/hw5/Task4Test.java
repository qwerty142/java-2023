package edu.hw5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
public class Task4Test {
    static Stream<Arguments> CorrectPasswords() {
        return Stream.of(
            Arguments.of("qwe~rty"),
            Arguments.of("qwe!rty"),
            Arguments.of("qwe@rty"),
            Arguments.of("qwe#rty"),
            Arguments.of("qwe$rty"),
            Arguments.of("qwe%rty"),
            Arguments.of("qwe^rty"),
            Arguments.of("qwe&rty"),
            Arguments.of("qwe*rty"),
            Arguments.of("qwe|rty")
        );
    }

    @ParameterizedTest
    @MethodSource("CorrectPasswords")
    public void CorrectPasswordTest(String password) {
        assertThat(Task4.checkPassword(password)).isTrue();
    }

    @Test
    public void IncorrectPasswordTest() {
        String incorrectPassword = "asdg";

        assertThat(Task4.checkPassword(incorrectPassword)).isFalse();
    }
}
