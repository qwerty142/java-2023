package edu.project1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public record GameDictionary() {
    static List<String> words;

    public GameDictionary() {
        words = new ArrayList<>();
        words.add("tree");
        words.add("car");
        words.add("dependency");
        words.add("playground");
    }

    public void addWord(String word) {
        words.add(word);
    }

    public String generateWord() {
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }

}
