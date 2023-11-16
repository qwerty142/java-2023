package edu.hw4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import static edu.hw4.StreamTasks.animalsByBiggestWeight;
import static org.assertj.core.api.Assertions.assertThat;
public class Task6Test {
    private final static Animal fish = new Animal("F", Animal.Type.FISH, Animal.Sex.F, 1, 2, 1, false);
    private final static Animal bird = new Animal("B", Animal.Type.BIRD, Animal.Sex.M, 1, 7, 2, false);
    private final static Animal cat = new Animal("C", Animal.Type.CAT, Animal.Sex.M, 1, 3, 3, true);
    private final static Animal cat1 = new Animal("C1", Animal.Type.CAT, Animal.Sex.M, 1, 16, 4, false);
    private final static Animal dog = new Animal("D", Animal.Type.DOG, Animal.Sex.F, 1, 16, 5, false);
    private final static Animal spider = new Animal("S", Animal.Type.SPIDER, Animal.Sex.M, 1, 7, 6, true);

    static Stream<Arguments> task6Args() {
        return Stream.of(
            Arguments.of(List.of(), Map.of()),
            Arguments.of(
                List.of(cat, fish, spider)
                , Map.of(Animal.Type.CAT, cat, Animal.Type.FISH, fish, Animal.Type.SPIDER, spider)),
            Arguments.of(
                List.of(cat, cat1, dog)
                , Map.of(Animal.Type.CAT, cat1, Animal.Type.DOG, dog))
        );
    }
    @ParameterizedTest
    @MethodSource("task6Args")
    public void shouldReturnMapOfAnimalsByBiggestWeight(List<Animal> animals, Map<Animal.Type, Animal> result) {
        assertThat(animalsByBiggestWeight(animals)).isEqualTo(result);
    }
}
