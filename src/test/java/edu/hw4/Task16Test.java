package edu.hw4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static edu.hw4.StreamTasks.animalsSortedByTypeSexName;
import static org.assertj.core.api.Assertions.assertThat;
public class Task16Test {
    private final static Animal catMaleA = new Animal("A", Animal.Type.CAT, Animal.Sex.M, 1, 1, 1, false);
    private final static Animal catFemaleA = new Animal("A", Animal.Type.CAT, Animal.Sex.F, 1, 1, 1, false);
    private final static Animal dogMaleA = new Animal("A", Animal.Type.DOG, Animal.Sex.M, 1, 1, 1, false);
    private final static Animal dogFemaleA = new Animal("A", Animal.Type.DOG, Animal.Sex.F, 1, 1, 1, false);
    private final static Animal birdMaleA = new Animal("A", Animal.Type.BIRD, Animal.Sex.M, 1, 1, 1, false);
    private final static Animal spiderMaleA = new Animal("A", Animal.Type.SPIDER, Animal.Sex.M, 1, 1, 1, false);
    private final static Animal fishMaleA = new Animal("A", Animal.Type.FISH, Animal.Sex.M, 1, 1, 1, false);
    private final static Animal fishMaleB = new Animal("B", Animal.Type.FISH, Animal.Sex.M, 1, 1, 1, false);

    static Stream<Arguments> task16Args() {
        return Stream.of(
            Arguments.of(
                List.of(),
                List.of()
            ),

            Arguments.of(
                List.of(catFemaleA),
                List.of(catFemaleA)
            ),

            Arguments.of(
                List.of(fishMaleA, spiderMaleA, catMaleA, dogMaleA, birdMaleA),
                List.of(catMaleA, dogMaleA, birdMaleA, fishMaleA, spiderMaleA)
            ),

            Arguments.of(
                List.of(catMaleA, dogMaleA, birdMaleA, fishMaleB, fishMaleA),
                List.of(catMaleA, dogMaleA, birdMaleA, fishMaleA, fishMaleB)
            ),

            Arguments.of(
                List.of(fishMaleA, fishMaleB, birdMaleA, spiderMaleA, catMaleA, catFemaleA, dogMaleA, dogFemaleA),
                List.of(catMaleA, catFemaleA, dogMaleA, dogFemaleA, birdMaleA, fishMaleA, fishMaleB, spiderMaleA)
            )
        );
    }
    @ParameterizedTest
    @MethodSource("task16Args")
    public void shouldReturnAnimalsSortedByTypeSexName(List<Animal> animals, List<Animal> expectedResult) {

        assertThat(animalsSortedByTypeSexName(animals)).isEqualTo(expectedResult);
    }
}
