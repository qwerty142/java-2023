package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTaskSeven {
    static Arguments[] TestsForRight() {
        return new Arguments[] {
            Arguments.of(8, 1, 4), // right
            Arguments.of(16, 2, 4), // right
        };
    }

    static Arguments[] TestsForLeft() {
        return new Arguments[] {
            Arguments.of(16, 1, 1), // left
            Arguments.of(17, 2, 6), // left
        };
    }

    @DisplayName("циклический сдвиг")
    @ParameterizedTest
    @MethodSource("TestsForRight")
    public void CheckTask7Right(int num, int rotate, int result) {
        assertThat(Task7.rightRotate(num, rotate)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("TestsForLeft")
    public void CheckTask7Left(int num, int rotate, int result) {
        assertThat(Task7.leftRotate(num, rotate)).isEqualTo(result);
    }

}
