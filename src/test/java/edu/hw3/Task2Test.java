package edu.hw3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    static Arguments[] clusterize() {
        return new Arguments[] {
            Arguments.of("()()()", Arrays.stream((new String[] { "()", "()", "()" })).toList()),
            Arguments.of("((()))", Arrays.stream((new String[] { "((()))" })).toList()),
            Arguments.of("((()))(())()()(()())", Arrays.stream((new String[] { "((()))", "(())", "()", "()", "(()())" })).toList()),
            Arguments.of("((())())(()(()()))", Arrays.stream((new String[] { "((())())", "(()(()()))" })).toList()),
        };
    }
    @ParameterizedTest
    @MethodSource("clusterize")
    public void clusterizeTest(String input, List<String> result) {
        assertThat(Task2.clusterize(input)).isEqualTo(result);
    }
}
