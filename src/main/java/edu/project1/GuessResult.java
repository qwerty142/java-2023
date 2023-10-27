package edu.project1;

import org.jetbrains.annotations.NotNull;

public interface GuessResult {
    String state();

    int attempt();

    int maxAttempts();

    @NotNull String message();
}
