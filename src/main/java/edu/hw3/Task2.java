package edu.hw3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public final class Task2 {

    private Task2() {}

    public static List<String> clusterize(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input string cant be null");
        }
        List<String> result = new ArrayList<>();
        Stack<Character> brackets = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (char symbol : input.toCharArray()) {
            stringBuilder.append(symbol);
            if (symbol == '(') {
                brackets.push(symbol);
            } else if (symbol == ')') {
                if (!brackets.empty()) {
                    brackets.pop();
                } else {
                    throw new IllegalArgumentException("Unable to cluster elements in input string");
                }
            }
            if (brackets.empty()) {
                result.add(stringBuilder.toString());
                stringBuilder.setLength(0);
            }
        }
        return result;
    }
}
