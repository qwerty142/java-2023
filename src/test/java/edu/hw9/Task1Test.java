package edu.hw9;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    private static Stream<Arguments> dataTest() {
        return Stream.of(
            Arguments.of(
                List.of(new double[] {1, 2, 3},
                new double[] {5, 7, 1, -10},
                new double[] {1, 2, 3, 4, 5, 6, 7, 7, 8, 9}),
                Map.of(
                    "Stats 1", new Statistic(6, 1, 2),
                    "Stats 2", new Statistic(3, -10, 0.75),
                    "Stats 3", new Statistic(52, 1, 5.2)
                )
            )
        );
    }

    @ParameterizedTest
    @MethodSource("dataTest")
    public void correctWorkOfPrallelTest(List<double[]> stats, Map<String, Statistic> result)
        throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        Task1 collector = new Task1(3);
        for (int i = 0; i < stats.size(); i++) {
            int finalI = i + 1;
            int finalI1 = i;
            service.execute(() -> collector.addStats("Stats " + finalI, stats.get(finalI1)));
        }
        service.shutdown();
        service.awaitTermination(10000, TimeUnit.MILLISECONDS);
        assertThat(collector.getData()).isEqualTo(result);
    }
}
