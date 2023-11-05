package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.StreamTasks.mostWeightedFish;
import static org.assertj.core.api.Assertions.assertThat;
public class Task18Test {
    private final static Animal fish = new Animal("F", Animal.Type.FISH, Animal.Sex.F, 1, 2, 1, false);
    private final static Animal bird = new Animal("B r", Animal.Type.BIRD, Animal.Sex.M, 1, 7, 2, false);
    private final static Animal cat = new Animal("C", Animal.Type.CAT, Animal.Sex.M, 4, 3, 3, true);
    private final static Animal cat1 = new Animal("C1 g", Animal.Type.CAT, Animal.Sex.M, 4, 16, 4, false);
    private final static Animal dog = new Animal("D", Animal.Type.DOG, Animal.Sex.F, 4, 16, 5, false);
    private final static Animal spider = new Animal("S", Animal.Type.SPIDER, Animal.Sex.M, 6, 7, 6, true);
    private final static Animal fish1 = new Animal("S", Animal.Type.FISH, Animal.Sex.M, 6, 7, 6, true);
    private final static Animal fish2 = new Animal("S", Animal.Type.FISH, Animal.Sex.M, 6, 7, 10, true);

    @Test
    public void shouldReturnMostWeightedFish() {
        // Given
        List<Animal> first = List.of(fish, bird, cat);
        List<Animal> second = List.of(fish1, dog, cat);
        List<Animal> third = List.of(fish2, spider, cat1);
        List<List<Animal>> animals = List.of(first, second, third);
        Animal expected = fish2;
        // When
        Animal res = mostWeightedFish(animals);
        // Then
        assertThat(res).isEqualTo(expected);

    }
}
