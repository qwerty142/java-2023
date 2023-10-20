package edu.project1;

import java.util.List;
import java.util.Random;
import org.jetbrains.annotations.NotNull;

public class GDitionary implements Dictionary {
    List<String> words;

    public GDitionary() {
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
