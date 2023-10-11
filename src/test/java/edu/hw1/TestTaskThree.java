package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTaskThree {
    static Arguments[] Tests() {
        return new Arguments[] {Arguments.of(new int[] {}, new int[] {}, false),
            Arguments.of(new int[] {}, new int[] {1}, true),
            Arguments.of(new int[] {1}, new int[] {}, false),
            Arguments.of(new int[] {1}, new int[] {1}, false),
            Arguments.of(new int[] {5, 6, 7}, new int[] {1, 8}, true),
            Arguments.of(new int[] {1, 2, 3}, new int[] {0, 1, 2, 3, 6, 8, 9}, true),
            Arguments.of(new int[] {9, 2, 6}, new int[] {1, 3, 0, 9}, false),
            Arguments.of(new int[] {5, 3, 9}, new int[] {0, 6, 1, 10}, true),
            Arguments.of(new int[] {-3, 6, 6, 6, 2, 8}, new int[] {-100, 67, 90, 1000, 1000}, true)
        };
    }

    @DisplayName("Возможность вставить первый массив во второй")
    @ParameterizedTest
    @MethodSource("Tests")
    public void CheckTask3(int[] first, int[] second, boolean result) {
        assertThat(Task3.check_array_on_nesting(first, second)).isEqualTo(result);

    }
}
