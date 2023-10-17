package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    // Given
    static Arguments[] Tests() {
        return new Arguments[] {
            Arguments.of(3333, -1), // Одинаковые числа
            Arguments.of(3524, 3),
            Arguments.of(67892, -1), // больше 4 знаков
            Arguments.of(6621, 5),
            Arguments.of(6554, 4),
            Arguments.of(1234, 3),
            Arguments.of(2, -1), //меньше 4 знаков
            Arguments.of(-5487, -1), // отрицательное число
            Arguments.of(6174, 0)};
    }

    @DisplayName("Количество ходов до числа Каплера") @ParameterizedTest @MethodSource("Tests")
    public void getKaprekerNum_shouldReturnAmountOfStepsToConvertCurrentNumToKeplerNum(int num, int amount_of_steps) {
        // When
        int steps = Task6.getKaprekerNum(num,0);
        // Then
        assertThat(steps).isEqualTo(amount_of_steps);
    }
}

