package edu.hw4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.SplittableRandom;
import java.util.stream.Stream;
import static edu.hw4.StreamTasks.animalsWithWeightBiggerThanHeight;
import static org.assertj.core.api.Assertions.assertThat;
public class Task12Test {
    private final static Animal fish = new Animal("F", Animal.Type.FISH, Animal.Sex.F, 1, 2, 1, false);
    private final static Animal bird = new Animal("B", Animal.Type.BIRD, Animal.Sex.M, 1, 7, 8, false);
    private final static Animal cat = new Animal("C", Animal.Type.CAT, Animal.Sex.M, 4, 3, 5, true);
    private final static Animal cat1 = new Animal("C1", Animal.Type.CAT, Animal.Sex.M, 4, 16, 4, false);
    private final static Animal dog = new Animal("D", Animal.Type.DOG, Animal.Sex.F, 4, 16, 5, false);
    private final static Animal spider = new Animal("S", Animal.Type.SPIDER, Animal.Sex.M, 6, 7, 12, true);

    static Stream<Arguments> task12Args() {
        return Stream.of(
            Arguments.of(List.of(), 0),
            Arguments.of(List.of(fish), 0),
            Arguments.of(List.of(fish, bird, cat, cat1, dog, spider), 3)
        );
    }
    @ParameterizedTest
    @MethodSource("task12Args")
    public void shouldReturnAnimalsWithWeightBiggerThanHeight(List<Animal> animals, Integer result) {

        assertThat(animalsWithWeightBiggerThanHeight(animals)).isEqualTo(result);
    }
 }
