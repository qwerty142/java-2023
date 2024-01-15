package edu.project1;

import org.apache.logging.log4j.LogBuilder;
import org.apache.logging.log4j.message.MessageFactory;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestHangMan {
    private static final String ANSWER = "qwerty";
    private static final String DEFEAT_ANSWER = "asdfgh";

    private static class DictionaryForTest implements HangManDictionary {

        @Override
        public @NotNull String randomWord() {
            return "qwerty";
        }
    }

        @Test
        public void testWinAndSuccessfulGuess() {
            // Given
            HangMan hangMan = new HangMan(5, new DictionaryForTest(), null);
            List<Character> answers = new ArrayList<>();
            for (int i = 0; i < ANSWER.length() - 1; i++) {
                answers.add(ANSWER.charAt(i));
            }
            //When
            for (var elem : answers) {
                GuessResult guessResult = hangMan.tryGuess(String.valueOf(elem));
                assertThat(guessResult).isInstanceOf(ResultsOfGuess.SuccessfulGuess.class);
            }
            //Then
            GuessResult guessResult = hangMan.tryGuess(String.valueOf(ANSWER.charAt(ANSWER.length() - 1)));
            assertThat(guessResult).isInstanceOf(ResultsOfGuess.Win.class);
        }
        @Test
        public void testLooseAndFailedGuess(){
        // Given
            HangMan hangMan = new HangMan(5, new DictionaryForTest(), null);
            List<Character> answers = new ArrayList<>();
            for (int i = 0; i < DEFEAT_ANSWER.length() - 1; i++) {
                answers.add(DEFEAT_ANSWER.charAt(i));
            }
            // When + Then
            for (var elem : answers) {
                GuessResult guessResult = hangMan.tryGuess(String.valueOf(elem));
                assertThat(guessResult).isInstanceOf(ResultsOfGuess.FailedGuess.class);
            }
            GuessResult guessResult = hangMan.tryGuess(String.valueOf(DEFEAT_ANSWER.charAt(DEFEAT_ANSWER.length() - 1)));
            // Then
            assertThat(guessResult).isInstanceOf(ResultsOfGuess.Defeat.class);
        }

    @ParameterizedTest
    @ValueSource(strings = {"7", "/", "`", "[]", "kl"})
        public void testIncorrectInput(String input){
            // Given
            HangMan hangMan = new HangMan(5, new DictionaryForTest(), null);
            // When
            GuessResult guessResult = hangMan.tryGuess(input);
            // Then
            assertThat(guessResult).isInstanceOf(ResultsOfGuess.FailedInputGuess.class);
        }
        @Test
        public void testRepeating(){
            // Given
            HangMan hangMan = new HangMan(5, new DictionaryForTest(), null);
            // When
            GuessResult guessResultFirst = hangMan.tryGuess("e");
            GuessResult guessResultSecond = hangMan.tryGuess("e");
            // Then
            assertThat(guessResultSecond).isInstanceOf(ResultsOfGuess.SameGuess.class);
        }
        @Test
        public void testGiveUp(){
            // Given
            HangMan hangMan = new HangMan(5, new DictionaryForTest(), null);
            String input = "";
            // When
            GuessResult guessResult = hangMan.tryGuess(input);
            // Then
            assertThat(guessResult).isInstanceOf(ResultsOfGuess.Defeat.class);

        }

        @Test
        public void testDefaultWork() {
            Stack<String> messages = new Stack<>();
            messages.push("y");
            messages.push("t");
            messages.push("r");
            messages.push("e");
            messages.push("w");
            messages.push("q");

            HangMan hangMan = new HangMan(5, new DictionaryForTest(), messages);
            hangMan.run();
            assertThat(hangMan.messageBox.empty()).isTrue();

        }
    }

