package edu.project1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HangMan {
    private final HangManDictionary gDictionary;
    private final Session session;
    private final int maxAttempts;
    private final String answer;
    private static Logger logger = LogManager.getLogger();

    public HangMan(int maxAttempts, HangManDictionary dictionary) {
        gDictionary = dictionary;
        this.maxAttempts = maxAttempts;
        answer = gDictionary.randomWord();
        session = new Session(answer, maxAttempts);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        logger.trace("Welcome to HangMan game");
        logger.trace("You have" + Integer.toString(maxAttempts));
        logger.trace("If you want to stop game, just press enter without writing any things");
        String input;
        while (true) {
            logger.trace("Enter symbol");
            input = scanner.hasNext() ? scanner.nextLine() : "";
            GuessResult result = tryGuess(input);
            printState(result);
            if (result instanceof ResultsOfGuess.Defeat
                || result instanceof ResultsOfGuess.Win) {
                break;
            }
        }
    }

    protected GuessResult tryGuess(String input) {
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
        logger.trace(guess.message());
        logger.trace("Current word is" + guess.state());
    }
}
