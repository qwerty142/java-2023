package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Test_for_task_1 {
    @Test
    @DisplayName("Общая длина видео в секундах")
    @ValueSource
    void CheckTask1() {
        // given

        int first = Task1.get_sum("10:10"); // 610
        int second = Task1.get_sum("00:00"); // 0
        int third = Task1.get_sum("100:40"); // 6040
        int four = Task1.get_sum("00: 78"); // fall from seconds limit
        int five = Task1.get_sum("abc:df"); // fall from uncorect symbals
        // when
        int res_1 = 610;
        int res_2 = 0;
        int res_3 = 6040;
        int res_4 = -1;
        int res_5 = -1;

        // then
        assertThat(first).isEqualTo(res_1);
        assertThat(second).isEqualTo(res_2);
        assertThat(third).isEqualTo(res_3);
        assertThat(four).isEqualTo(res_4);
        assertThat(five).isEqualTo(res_5);
    }
}
