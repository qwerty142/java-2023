package edu.project1;

import java.util.Stack;

public class HangMan {
    private final HangManDictionary gameDictionary;
    private final Session session;
    private final int maxAttempts;
    protected final MessageLogger messageLogger = new MessageLogger();
    protected final Stack<String> messageBox;

    public HangMan(int maxAttempts, HangManDictionary dictionary, Stack<String> messageBox) {
        gameDictionary = dictionary;
        this.maxAttempts = maxAttempts;
        String answer = gameDictionary.randomWord();
        session = new Session(answer, maxAttempts);
        this.messageBox = messageBox;
    }

    public void run() {
        messageLogger.writeMessage("Welcome to HangMan game");
        messageLogger.writeMessage("You have" + maxAttempts);
        messageLogger.writeMessage("If you want to stop game, just press enter without writing any things");
        String input;
        while (true) {
            messageLogger.writeMessage("Enter symbol");
            if (messageBox == null) {
                input = messageLogger.getMessage("");
            } else {
                input = messageLogger.getMessage(messageBox.peek());
                messageBox.pop();
            }
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
        messageLogger.writeMessage(guess.message());
        messageLogger.writeMessage("Current word is" + guess.state());
    }
}
