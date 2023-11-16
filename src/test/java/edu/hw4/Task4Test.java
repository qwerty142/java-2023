package edu.hw4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static edu.hw4.StreamTasks.animalWithBiggestName;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class Task4Test {
    private final static Animal fish = new Animal("F", Animal.Type.FISH, Animal.Sex.F, 1, 2, 1, false);
    private final static Animal bird = new Animal("", Animal.Type.BIRD, Animal.Sex.M, 1, 7, 2, false);
    private final static Animal cat = new Animal("C", Animal.Type.CAT, Animal.Sex.M, 1, 3, 3, true);
    private final static Animal cat1 = new Animal("C1", Animal.Type.CAT, Animal.Sex.F, 1, 16, 4, false);
    private final static Animal dog = new Animal("D2345", Animal.Type.DOG, Animal.Sex.F, 1, 16, 5, false);
    private final static Animal spider = new Animal("S2", Animal.Type.SPIDER, Animal.Sex.M, 1, 7, 6, true);

    static Stream<Arguments> task4Arguments() {
        return Stream.of(
            Arguments.of(List.of(fish, bird, cat, cat1, dog, spider), dog),
            Arguments.of(List.of(spider, cat1), spider),
            Arguments.of(List.of(spider), spider)
        );
    }
    @ParameterizedTest
    @MethodSource("task4Arguments")
    public void shouldReturnAnimalWithBiggestName(List<Animal> input, Animal animal) {
        assertThat(animalWithBiggestName(input)).isEqualTo(animal);

    }
}
