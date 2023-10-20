package edu.project1;

import java.io.IOException;

public class Game implements GameLogic {
    private final GameDictionary gameDictionary = new GameDictionary();
    private final String looseNotification = "You lose!";
    private final String winNotification = "You guess!";
    private String currentWord;
    private String wishfulWord;
    InputReader inputReader = new InputReader();
    private int ableMistakes;
    private boolean gameStatus = true;

    @Override
    public void startGame() {
        wishfulWord = gameDictionary.generateWord();
        currentWord = new String(new char[wishfulWord.length()]).replace('\0', '*');
        ableMistakes = wishfulWord.length();
    }

    @SuppressWarnings("checkstyle:ReturnCount") @Override
    public void getInput() throws IOException {
        char c = inputReader.getSymbol();
        for (int i = 0; i < wishfulWord.length(); i++) {
            if (wishfulWord.charAt(i) == c && currentWord.charAt(i) == '*') {
                StringBuilder stringBuilder = new StringBuilder(currentWord);
                stringBuilder.setCharAt(i, c);
                currentWord = stringBuilder.toString();
                inputReader.writeMessage("You guess one symbol!");
                inputReader.writeMessage(currentWord);
                if (!currentWord.contains("*")) {
                    inputReader.writeMessage(winNotification);
                    gameStatus = false;
                }
                return;
            }
        }
        inputReader.writeMessage("You didnt guess");
        ableMistakes -= 1;
        if (ableMistakes < 0) {
            inputReader.writeMessage(looseNotification);
            gameStatus = false;
            return;
        }
        inputReader.writeMessage(String.valueOf(ableMistakes) + " mistakes left");
    }

    @Override
    public void play() throws IOException {
        startGame();
        do {
            getInput();
        } while (gameStatus);
    }
}
