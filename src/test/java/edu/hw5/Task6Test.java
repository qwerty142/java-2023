package edu.hw5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task6Test {
    static Stream<Arguments> CorrectSubs() {
        return Stream.of(
            Arguments.of("achfdbaabgabcaabg", "abc"),
            Arguments.of("abcdfrg", "abcdfr"),
            Arguments.of("fffff", "fff"),
            Arguments.of("asdf", "asdf") // same
        );
    }

    @ParameterizedTest
    @MethodSource("CorrectSubs")
    public void TestCorrectSub(String string, String sub) {
        assertThat(Task6.checkOnSubString(sub, string)).isTrue();
    }

    @Test
    public void TestOnNull() {
        assertThrows(NullPointerException.class, () -> Task6.checkOnSubString(null, null));
        assertThrows(NullPointerException.class, () -> Task6.checkOnSubString("ac", null));
        assertThrows(NullPointerException.class, () -> Task6.checkOnSubString(null, "ac"));
    }

    static Stream<Arguments> InCorrectSubs() {
        return Stream.of(
            Arguments.of("achfdbaabgabcaabg", "zxc"),
            Arguments.of("abcdfrg", "abcdfrgt"),
            Arguments.of("fffff", " ")
        );
    }

    @ParameterizedTest
    @MethodSource("InCorrectSubs")
    public void TestIncorrectSub(String string, String sub) {
        assertThat(Task6.checkOnSubString(sub, string)).isFalse();
    }
}
