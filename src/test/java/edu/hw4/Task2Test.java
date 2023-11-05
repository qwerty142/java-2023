package edu.hw4;
import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.StreamTasks.sortAnimalsWeight;
import static org.assertj.core.api.Assertions.assertThat;
public class Task2Test {
    private final static Animal fish = new Animal("F", Animal.Type.FISH, Animal.Sex.F, 1, 2, 1, false);
    private final static Animal bird = new Animal("B", Animal.Type.BIRD, Animal.Sex.M, 1, 7, 2, false);
    private final static Animal cat = new Animal("C", Animal.Type.CAT, Animal.Sex.M, 1, 3, 3, true);
    private final static Animal cat1 = new Animal("C1", Animal.Type.CAT, Animal.Sex.F, 1, 16, 4, false);
    private final static Animal dog = new Animal("D", Animal.Type.DOG, Animal.Sex.F, 1, 16, 5, false);
    private final static Animal spider = new Animal("S", Animal.Type.SPIDER, Animal.Sex.M, 1, 7, 6, true);

    @Test
    public void ShouldReturnByWeight() {
        // Given
        List<Animal> animals = List.of(spider, dog, cat, cat1, bird, fish);
        List<Animal> expected = List.of(spider, dog);
        // When
        List<Animal> result = sortAnimalsWeight(animals, 2);
        // Then
        assertThat(result).isEqualTo(expected);
    }
}
