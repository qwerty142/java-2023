package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    //Given for right rotate
    static Arguments[] TestsForRight() {
        return new Arguments[] {
            Arguments.of(8, 1, 4), // right
            Arguments.of(16, 2, 4), // right
            Arguments.of(16, -1, 1), // right
            Arguments.of(6, 0, 6) // right
        };
    }
    //Given for left rotate
    static Arguments[] TestsForLeft() {
        return new Arguments[] {
            Arguments.of(16, 1, 1), // left
            Arguments.of(17, 2, 6), // left
            Arguments.of(8, -1, 4), // left
            Arguments.of(6, 0, 6) // left
        };
    }

    @DisplayName("циклический сдвиг")
    @ParameterizedTest
    @MethodSource("TestsForRight")
    public void rightRotate_shouldReturnNumAfterCycleRightRotate(int num, int rotate, int result) {
        //When
        int rotatedNum = Task7.rightRotate(num,rotate);
        //Then
        assertThat(rotatedNum).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("TestsForLeft")
    public void leftRotate_shouldReturnNumAfterCycleLeftRotate(int num, int rotate, int result) {
        //When
        int rotatedNum = Task7.leftRotate(num,rotate);
        //Then
        assertThat(rotatedNum).isEqualTo(result);
    }

}
