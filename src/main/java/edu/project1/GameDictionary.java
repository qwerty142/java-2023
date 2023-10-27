package edu.project1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.jetbrains.annotations.NotNull;

public class GameDictionary implements HangManDictionary {
    List<String> words;

    public GameDictionary() {
        words = new ArrayList<>();
        words.add("tree");
        words.add("car");
        words.add("mobile");
    }

    @Override
    public @NotNull String randomWord() {
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }
}
