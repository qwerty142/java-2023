package edu.hw1.project;

import edu.project1.GuessResult;
import edu.project1.HangMan;
import edu.project1.HangManDictionary;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestHangMan {
    private static final String ANSWER = "qwerty";
    private static final String DEFEAT_ANSWER = "asdfgh";

    private static class DictionaryForTest implements HangManDictionary {

        @Override
        public @NotNull String randomWord() {
            return "qwerty";
        }
    }
        // Пришлось многое делать паблик чтобы можно было протестить
        @Test
        public void testWin() throws IOException {
            // Given
            HangMan hangMan = new HangMan(5, new DictionaryForTest());
            List<Character> answers = new ArrayList<>();
            for (int i = 0; i < ANSWER.length() - 1; i++) {
                answers.add(ANSWER.charAt(i));
            }
            //When
            for (var elem : answers) {
                GuessResult guessResult = hangMan.tryGuess(String.valueOf(elem));
                assertThat(guessResult).isInstanceOf(GuessResult.SuccessfulGuess.class);
            }
            //Then
            GuessResult guessResult = hangMan.tryGuess(String.valueOf(ANSWER.charAt(ANSWER.length() - 1)));
            assertThat(guessResult).isInstanceOf(GuessResult.Win.class);
        }
        @Test
        public void testLoose(){
        // Given
            HangMan hangMan = new HangMan(5, new DictionaryForTest());
            List<Character> answers = new ArrayList<>();
            for (int i = 0; i < DEFEAT_ANSWER.length() - 1; i++) {
                answers.add(DEFEAT_ANSWER.charAt(i));
            }
            // When
            for (var elem : answers) {
                GuessResult guessResult = hangMan.tryGuess(String.valueOf(elem));
                assertThat(guessResult).isInstanceOf(GuessResult.FailedGuess.class);
            }
            GuessResult guessResult = hangMan.tryGuess(String.valueOf(DEFEAT_ANSWER.charAt(DEFEAT_ANSWER.length() - 1)));
            // Then
            assertThat(guessResult).isInstanceOf(GuessResult.Defeat.class);
        }
    static Arguments[] Tests() {
        return new Arguments[] {
            Arguments.of("7"),
            Arguments.of("/"),
            Arguments.of("`"),
            Arguments.of("[]"),
            Arguments.of("kl"),
        };
    }
    @ParameterizedTest
    @MethodSource("Tests")
        public void testIncorrectInput(String input){
            // Given
            HangMan hangMan = new HangMan(5, new DictionaryForTest());
            // When
            GuessResult guessResult = hangMan.tryGuess(input);
            // Then
            assertThat(guessResult).isInstanceOf(GuessResult.FailedInputGuess.class);
        }
        @Test
        public void testRepeating(){
            // Given
            HangMan hangMan = new HangMan(5, new DictionaryForTest());
            // When
            GuessResult guessResultFirst = hangMan.tryGuess("e");
            GuessResult guessResultSecond = hangMan.tryGuess("e");
            // Then
            assertThat(guessResultSecond).isInstanceOf(GuessResult.FailedInputGuess.class);
        }
        @Test
        public void testGiveUp(){
            // Given
            HangMan hangMan = new HangMan(5, new DictionaryForTest());
            String input = "";
            // When
            GuessResult guessResult = hangMan.tryGuess(input);
            // Then
            assertThat(guessResult).isInstanceOf(GuessResult.Defeat.class);

        }
    }

