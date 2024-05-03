package edu.hw4;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static edu.hw4.StreamTasks.getFirstNAnimalsByWeight;
import static org.assertj.core.api.Assertions.assertThat;
public class Task2Test {
    private final static Animal fish = new Animal("F", Animal.Type.FISH, Animal.Sex.F, 1, 2, 1, false);
    private final static Animal bird = new Animal("B", Animal.Type.BIRD, Animal.Sex.M, 1, 7, 2, false);
    private final static Animal cat = new Animal("C", Animal.Type.CAT, Animal.Sex.M, 1, 3, 3, true);
    private final static Animal cat1 = new Animal("C1", Animal.Type.CAT, Animal.Sex.F, 1, 16, 4, false);
    private final static Animal dog = new Animal("D", Animal.Type.DOG, Animal.Sex.F, 1, 16, 5, false);
    private final static Animal spider = new Animal("S", Animal.Type.SPIDER, Animal.Sex.M, 1, 7, 6, true);

    static Stream<Arguments> task2Args() {
        return Stream.of(
            Arguments.of(List.of(), List.of(), 0),
            Arguments.of(List.of(cat, dog, bird), List.of(dog, cat, bird), 3),
            Arguments.of(List.of(fish, bird), List.of(bird), 1),
            Arguments.of(List.of(fish, bird, cat, cat1, dog, spider), List.of(spider, dog, cat1), 3)
        );
    }
    @ParameterizedTest
    @MethodSource("task2Args")
    public void shouldReturnByWeight(List<Animal> input, List<Animal> res, int amount) {
        assertThat(getFirstNAnimalsByWeight(input, amount)).isEqualTo(res);
    }
}
