package edu.hw4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static edu.hw4.StreamTasks.isSpidersBiteMoreThanDogs;
import static org.assertj.core.api.Assertions.assertThat;
public class Task17Test {
    private final static Animal spiderBites = new Animal("", Animal.Type.SPIDER, Animal.Sex.M, 1, 1, 1, true);
    private final static Animal spiderNotBites = new Animal("", Animal.Type.SPIDER, Animal.Sex.M, 1, 1, 1, false);
    private final static Animal dogBites = new Animal("", Animal.Type.DOG, Animal.Sex.M, 1, 1, 1, true);
    private final static Animal dogNotBites = new Animal("", Animal.Type.DOG, Animal.Sex.M, 1, 1, 1, false);

    static Stream<Arguments> tsk17Args() {
        return Stream.of(
            Arguments.of(
                List.of(),
                false
            ),

            Arguments.of(
                List.of(spiderBites),
                true
            ),

            Arguments.of(
                List.of(spiderBites, dogBites),
                false
            ),

            Arguments.of(
                List.of(dogNotBites, dogBites, spiderNotBites),
                false
            ),

            Arguments.of(
                List.of(spiderBites, spiderNotBites, spiderNotBites, dogBites, dogBites),
                false
            )
        );
    }
    @ParameterizedTest
    @MethodSource("tsk17Args")
    public void shouldReturnIsSpidersBiteMoreThanDogs(List<Animal> animals, Boolean expectedResult) {

        assertThat(isSpidersBiteMoreThanDogs(animals)).isEqualTo(expectedResult);
    }
}
