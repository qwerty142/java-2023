package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static edu.hw4.StreamTasks.summaryWeightOfEachAnimalOfNeededAge;
import static org.assertj.core.api.Assertions.assertThat;
public class Task15Test {
    private final static Animal fish = new Animal("F", Animal.Type.FISH, Animal.Sex.F, 1, 2, 1, false);
    private final static Animal bird = new Animal("B r", Animal.Type.BIRD, Animal.Sex.M, 1, 7, 2, false);
    private final static Animal cat = new Animal("C", Animal.Type.CAT, Animal.Sex.M, 4, 3, 3, true);
    private final static Animal cat1 = new Animal("C1 g", Animal.Type.CAT, Animal.Sex.M, 4, 16, 4, false);
    private final static Animal dog = new Animal("D", Animal.Type.DOG, Animal.Sex.F, 4, 16, 5, false);
    private final static Animal spider = new Animal("S", Animal.Type.SPIDER, Animal.Sex.M, 6, 7, 6, true);

    @Test
    public void shouldReturnSummaryWeightOfEachAnimalOfNeededAge() {
        // Given
        List<Animal> animals = List.of(fish, cat, cat1);
        Map<Animal.Type, Integer> expected = new HashMap<>();
        expected.put(fish.type(), 1);
        expected.put(Animal.Type.CAT, 7);
        // When
        Map<Animal.Type, Integer> res = summaryWeightOfEachAnimalOfNeededAge(animals, 0, 1000);
        // Then
        assertThat(res).isEqualTo(expected);

    }
}
