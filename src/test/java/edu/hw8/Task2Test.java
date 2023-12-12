package edu.hw8;

import edu.hw8.Task2.FixedThreadPool;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    @Test
    public void checkThreadPoolOnFibbonachi() throws Exception {
        int[] expect = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89};

        try (FixedThreadPool threadPool = new FixedThreadPool(4)) {
            threadPool.start();
            for(int i = 0; i < expect.length; i++) {
                int i1 = i;
                threadPool.execute(() -> {
                    int res = countFib(i1);
                    assertThat(res).isEqualTo(expect[i1]);
                });
            }
        }
    }

    private int countFib(int num) {
        if (num <= 1) {
            return num;
        }
        return countFib(num - 1) + countFib(num - 2);
    }
}
