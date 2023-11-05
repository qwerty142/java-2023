package edu.hw4;

import edu.hw4.Validators.ValidateAge;
import edu.hw4.Validators.ValidateHeight;
import edu.hw4.Validators.ValidateWeight;
import edu.hw4.Validators.Validation;
import edu.hw4.Validators.ValidationError;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import static edu.hw4.StreamTasks.animalsWithErrors;
import static org.assertj.core.api.Assertions.assertThat;
public class Task19Test {
    private final static Animal fish = new Animal("F", Animal.Type.FISH, Animal.Sex.F, 1, -1, 1, false);
    private final static Animal bird = new Animal("B r", Animal.Type.BIRD, Animal.Sex.M, 1, 7, 2, false);
    private final static Animal cat = new Animal("C", Animal.Type.CAT, Animal.Sex.M, -1, 3, 3, true);
    private final static Animal cat1 = new Animal("C1 g", Animal.Type.CAT, Animal.Sex.M, 4, 16, -1, false);
    private final static Animal dog = new Animal("D", Animal.Type.DOG, Animal.Sex.F, 4, 16, 5, false);
    private final static Animal spider = new Animal("S", Animal.Type.SPIDER, Animal.Sex.M, 6, 7, 6, true);
    private final static Animal fish1 = new Animal("S", Animal.Type.FISH, Animal.Sex.M, 6, 7, 6, true);
    private final static Animal fish2 = new Animal("S", Animal.Type.FISH, Animal.Sex.M, 6, 7, 10, true);

    @Test
    public void shouldReturnAnimalsWithErrors() {
        // Given
        List<Animal> animals = List.of(fish, cat, cat1, dog, spider);
        Map<String, Set<ValidationError>> expected = new HashMap<>();
        expected.put("F", Set.of(new ValidationError("height", "Height is unreal")));
        expected.put("C", Set.of(new ValidationError("age", "unreal age")));
        expected.put("C1 g", Set.of(new ValidationError("weight", "unreal weight")));
        List<Validation> validations = List.of(new ValidateAge(), new ValidateHeight(), new ValidateWeight());
        // When
        Map<String, Set<ValidationError>> res = animalsWithErrors(animals, validations);
        // Then
        assertThat(res).isEqualTo(expected);
    }
}
