package edu.hw4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static edu.hw4.StreamTasks.countPaws;
import static org.assertj.core.api.Assertions.assertThat;
public class Task9Test {
    private final static Animal fish = new Animal("F", Animal.Type.FISH, Animal.Sex.F, 1, 2, 1, false);
    private final static Animal bird = new Animal("B", Animal.Type.BIRD, Animal.Sex.M, 2, 7, 2, false);
    private final static Animal cat = new Animal("C", Animal.Type.CAT, Animal.Sex.M, 3, 3, 3, true);
    private final static Animal cat1 = new Animal("C1", Animal.Type.CAT, Animal.Sex.M, 4, 16, 4, false);
    private final static Animal dog = new Animal("D", Animal.Type.DOG, Animal.Sex.F, 5, 16, 5, false);
    private final static Animal spider = new Animal("S", Animal.Type.SPIDER, Animal.Sex.M, 6, 7, 6, true);

    static Stream<Arguments> task9Args() {
        return Stream.of(
            Arguments.of(List.of(), 0),
            Arguments.of(List.of(fish), 0),
            Arguments.of(List.of(cat, cat1), 8),
            Arguments.of(List.of(fish, bird, cat, cat1, dog, spider), 22)
        );
    }
    @ParameterizedTest
    @MethodSource("task9Args")
    public void shouldReturnAmountOfAllPaws(List<Animal> animals, int result) {

        assertThat(countPaws(animals)).isEqualTo(result);
    }
}
