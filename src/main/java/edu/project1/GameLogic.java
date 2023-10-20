package edu.project1;

import java.io.IOException;

public interface GameLogic {
    void startGame();

    void getInput() throws IOException;

    void play() throws IOException;
}
