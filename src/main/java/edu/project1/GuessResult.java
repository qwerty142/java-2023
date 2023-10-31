package edu.project1;

import org.jetbrains.annotations.NotNull;

public sealed interface GuessResult {
    String state();

    int attempt();

    int maxAttempts();

    @NotNull String message();

    record Defeat(String state, int attempt, int maxAttempts) implements GuessResult {
        @Override
        public @NotNull String message() {
            return "You lost!\n";
        }
    }

    record Win(String state, int attempt, int maxAttempts) implements GuessResult {
        @Override
        public @NotNull String message() {
            return "You win!\n";
        }
    }

    record SuccessfulGuess(String state, int attempt, int maxAttempts) implements GuessResult {

        @Override
        public @NotNull String message() {
            return "You guess!\n";
        }
    }

    record FailedGuess(String state, int attempt, int maxAttempts) implements GuessResult {

        @Override
        public @NotNull String message() {
            return "You didnt guess\n";
        }
    }

    record SameGuess(String state) implements GuessResult {

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
            return "You alredy tryed this symbol\n";
        }
    }

    record FailedInputGuess(String state) implements GuessResult {

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
