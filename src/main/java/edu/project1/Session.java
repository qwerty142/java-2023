package edu.project1;

import java.util.HashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public class Session {
    private final String answer;
    private String userAnswer;
    private final int maxAttempts;
    private int attempts;
    private final Set<Character> alreadyUsedSymbols;

    public Session(String wishedWord, int maxAttempts) {
        this.answer = wishedWord;
        this.maxAttempts = maxAttempts;
        attempts = 0;
        alreadyUsedSymbols = new HashSet<>();
        userAnswer = new String(new char[answer.length()]).replace('\0', '*');
    }

    @SuppressWarnings("checkstyle:ReturnCount") @NotNull
    public GuessResult guess(char guess) {
        if (attempts >= maxAttempts) {
            return new GuessResult.Defeat(userAnswer, attempts, maxAttempts);
        }
        if (alreadyUsedSymbols.contains(guess)) {
            return new GuessResult.FailedInputGuess(userAnswer);
        }
        boolean guessSymbol = false;
        alreadyUsedSymbols.add(guess);
        for (int i = 0; i < answer.length(); i++) {
            if (guess == answer.charAt(i)) {
                StringBuilder stringBuilder = new StringBuilder(userAnswer);
                stringBuilder.setCharAt(i, guess);
                userAnswer = stringBuilder.toString();
                guessSymbol = true;
            }
        }

        if (guessSymbol) {
            if (!userAnswer.contains("*")) {
                return new GuessResult.Win(userAnswer, attempts, maxAttempts);
            }
            return new GuessResult.SuccessfulGuess(userAnswer, attempts, maxAttempts);
        }
        attempts++;
        return new GuessResult.FailedGuess(userAnswer, attempts, maxAttempts);
    }

    @NotNull GuessResult giveUp() {
        return new GuessResult.Defeat(userAnswer, attempts, maxAttempts);
    }

    @NotNull GuessResult uncorrectInput() {
        return new GuessResult.FailedInputGuess(userAnswer);
    }
}
