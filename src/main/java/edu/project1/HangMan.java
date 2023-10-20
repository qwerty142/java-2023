package edu.project1;

import java.util.Scanner;

public class HangMan {
    private final GDitionary gDitionary;
    private Session session;
    private final int maxAttempts;
    private final String answer;

    public HangMan(int maxAttempts) {
        this.maxAttempts = maxAttempts;
        gDitionary = new GDitionary();
        answer = gDitionary.randomWord();
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
            GuessResult result = tryGuess(session, input);
            printState(result);
            if (result instanceof GuessResult.Defeat
                || result instanceof GuessResult.Win) {
                break;
            }
        }
    }

    protected GuessResult tryGuess(Session session, String input) {
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
