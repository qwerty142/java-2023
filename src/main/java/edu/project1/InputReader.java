package edu.project1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class InputReader {
    private final BufferedReader bufferedReader;

    public InputReader() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
    }

    @SuppressWarnings("checkstyle:RegexpSinglelineJava")
    public char getSymbol() throws IOException {
        String input;
        do {
            System.out.println("Write symbol");
            input = "";
            input = bufferedReader.readLine();
            if (input.length() != 1) {
                System.out.println("Mistake in the entered symbol");
            } else {
                return input.charAt(0);
            }
        } while (true);
    }

    @SuppressWarnings("checkstyle:RegexpSinglelineJava")
    public void writeMessage(String message) {
        System.out.println(message);
    }
}
