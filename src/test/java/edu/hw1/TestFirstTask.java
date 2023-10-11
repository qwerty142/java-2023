package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestFirstTask {
    @Test @DisplayName("Общая длина видео в секундах") @ValueSource void CheckTask1() {
        // given

        int first = Task1.getSum("10:10"); // 610
        int second = Task1.getSum("00:00"); // 0
        int third = Task1.getSum("100:40"); // 6040
        int four = Task1.getSum("00: 78"); // fall from seconds limit
        int five = Task1.getSum("abc:df"); // fall from uncorrected symbols
        // when
        int res1 = 610;
        int res2 = 0;
        int res3 = 6040;
        int res4 = -1;
        int res5 = -1;

        // then
        assertThat(first).isEqualTo(res1);
        assertThat(second).isEqualTo(res2);
        assertThat(third).isEqualTo(res3);
        assertThat(four).isEqualTo(res4);
        assertThat(five).isEqualTo(res5);
    }
}
