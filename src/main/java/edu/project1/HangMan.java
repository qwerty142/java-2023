package edu.project1;

import java.util.Scanner;

public class HangMan {
    private final HangManDictionary gDictionary;
    private final Session session;
    private final int maxAttempts;
    private final String answer;

    public HangMan(int maxAttempts, HangManDictionary dictionary) {
        gDictionary = dictionary;
        this.maxAttempts = maxAttempts;
        answer = gDictionary.randomWord();
        session = new Session(answer, maxAttempts);
    }

    @SuppressWarnings("checkstyle:RegexpSinglelineJava")
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to HangMan game");
        System.out.println("You have" + Integer.toString(maxAttempts));
        System.out.println("If you want to stop game, just press enter without writing any things");
        String input;
        while (true) {
            System.out.println("Enter symbol");
            input = scanner.hasNext() ? scanner.nextLine() : "";
            GuessResult result = tryGuess(input);
            printState(result);
            if (result instanceof GuessResult.Defeat
                || result instanceof GuessResult.Win) {
                break;
            }
        }
    }

    public GuessResult tryGuess(String input) {
        if (input.equals("")) {
            return session.giveUp();
        }
        if (!input.matches("[a-z]")) {
            return session.uncorrectInput();
        }
        return session.guess(input.charAt(0));
    }

    @SuppressWarnings("checkstyle:RegexpSinglelineJava")
    private void printState(GuessResult guess) {
        System.out.println(guess.message());
        System.out.println("Current word is" + guess.state());
    }
}
