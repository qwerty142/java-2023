package edu.hw3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {
    static Stream<Arguments> parseContacts() {
        // Given
        return Stream.of(
            Arguments.of(
                List.of("John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"), "ASC",
                List.of(new Task5.Contact("Thomas", "Aquinas")
                    , new Task5.Contact("Rene", "Descartes")
                    , new Task5.Contact("David", "Hume")
                    , new Task5.Contact("John", "Locke"))),
            Arguments.of(
                List.of("Paul Erdos", "Leonhard Euler", "Carl Gauss"), "DESC",
                List.of(new Task5.Contact("Carl", "Gauss"), new Task5.Contact("Leonhard", "Euler"), new Task5.Contact("Paul", "Erdos"))),
            Arguments.of(
                List.of(), "DESC", List.of()
            ),
            Arguments.of(null, "DESC", List.of())
        );
    }
    @ParameterizedTest
    @MethodSource("parseContacts")
    public void parseContactsTest(List<String> input, String order, List<Task5.Contact> expectedResult) {
        // When
        List<Task5.Contact> result = Task5.parseContacts(input, order);
        // Then
        assertThat(result).isEqualTo(expectedResult);
    }
}
