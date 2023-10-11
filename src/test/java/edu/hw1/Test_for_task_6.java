package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class Test_for_task_6 {
    static Arguments[] Tests(){
        return new Arguments[]{
            Arguments.of(6621,5),
            Arguments.of(6554,4),
            Arguments.of(1234,3),
            Arguments.of(2,-1), //меньше 4 знаков
            Arguments.of(-5487,-1), // отрицательное число
            Arguments.of(6174,0)
        };
    }
    @DisplayName("Количество ходов до числа Каплера")
    @ParameterizedTest
    @MethodSource("Tests")
    public void CheckTask6(int num, int amount_of_steps){
        assertThat(Task6.get_Kapler(num,0)).isEqualTo(amount_of_steps);
    }
}

