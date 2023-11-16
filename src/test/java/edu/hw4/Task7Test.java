package edu.hw4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static edu.hw4.StreamTasks.kthOldAnimal;
import static org.assertj.core.api.Assertions.assertThat;
public class Task7Test {
    private final static Animal fish = new Animal("F", Animal.Type.FISH, Animal.Sex.F, 1, 2, 1, false);
    private final static Animal bird = new Animal("B", Animal.Type.BIRD, Animal.Sex.M, 2, 7, 2, false);
    private final static Animal cat = new Animal("C", Animal.Type.CAT, Animal.Sex.M, 4, 3, 3, true);
    private final static Animal cat1 = new Animal("C1", Animal.Type.CAT, Animal.Sex.M, 4, 16, 4, false);
    private final static Animal dog = new Animal("D", Animal.Type.DOG, Animal.Sex.F, 5, 16, 5, false);
    private final static Animal spider = new Animal("S", Animal.Type.SPIDER, Animal.Sex.M, 6, 7, 6, true);

    static Stream<Arguments> task7Args() {
        return Stream.of(
            Arguments.of(List.of(fish), 1, fish),
            Arguments.of(List.of(fish, bird, cat), 2, bird),
            Arguments.of(List.of(fish, cat, cat1), 1, cat)
        );
    }
    @ParameterizedTest
    @MethodSource("task7Args")
    public void shouldReturnKOldestAnimal(List<Animal> animals, int k, Animal result) {
        assertThat(kthOldAnimal(animals, k)).isEqualTo(result);
    }
}
