package edu.project1;

import org.jetbrains.annotations.NotNull;

public final class ResultsOfGuess {
    private ResultsOfGuess() {}

    public record Defeat(String state, int attempt, int maxAttempts) implements GuessResult {
        @Override
        public @NotNull String message() {
            return "You lost!\n";
        }
    }

    public record Win(String state, int attempt, int maxAttempts) implements GuessResult {
        @Override
        public @NotNull String message() {
            return "You win!\n";
        }
    }

    public record SuccessfulGuess(String state, int attempt, int maxAttempts) implements GuessResult {

        @Override
        public @NotNull String message() {
            return "You guess!\n";
        }
    }

    public record FailedGuess(String state, int attempt, int maxAttempts) implements GuessResult {

        @Override
        public @NotNull String message() {
            return "You didnt guess\n";
        }
    }

    public record SameGuess(String state) implements GuessResult {

        @Override
        public int attempt() {
            return 0;
        }

        @Override
        public int maxAttempts() {
            return 0;
        }

        @Override
        public @NotNull String message() {
            return "You already tried this symbol\n";
        }
    }

    public record FailedInputGuess(String state) implements GuessResult {

        @Override
        public int attempt() {
            return 0;
        }

        @Override
        public int maxAttempts() {
            return 0;
        }

        @Override
        public @NotNull String message() {
            return "You cant guess more than 1 symbol\n";
        }
    }
}
