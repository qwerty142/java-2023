package edu.hw1.project;

import edu.project1.Game;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class TestHangMan {
    @Test
    public void check() throws IOException {
        Game game = new Game();
        game.startGame();
        game.play();
    }
}
