package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.StreamTasks.biggestAmountOfAnimalsBySex;
import static org.assertj.core.api.Assertions.assertThat;
public class Task5Test {
    private final static Animal fish = new Animal("F", Animal.Type.FISH, Animal.Sex.F, 1, 2, 1, false);
    private final static Animal bird = new Animal("B", Animal.Type.BIRD, Animal.Sex.M, 1, 7, 2, false);
    private final static Animal cat = new Animal("C", Animal.Type.CAT, Animal.Sex.M, 1, 3, 3, true);
    private final static Animal cat1 = new Animal("C1", Animal.Type.CAT, Animal.Sex.M, 1, 16, 4, false);
    private final static Animal dog = new Animal("D", Animal.Type.DOG, Animal.Sex.F, 1, 16, 5, false);
    private final static Animal spider = new Animal("S", Animal.Type.SPIDER, Animal.Sex.M, 1, 7, 6, true);

    @Test
    public void shouldReturnBiggestSex() {
        // Given
        List<Animal> animals = List.of(fish, bird, cat, cat1, dog, spider);
        Animal.Sex expected = Animal.Sex.M;
        // When
        Animal.Sex res = biggestAmountOfAnimalsBySex(animals);
        // Then
        assertThat(res).isEqualTo(expected);
    }
}
