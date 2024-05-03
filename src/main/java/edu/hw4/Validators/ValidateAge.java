package edu.hw4.Validators;

import edu.hw4.Animal;

public class ValidateAge implements Validation {
    @SuppressWarnings("checkstyle:MagicNumber") @Override
    public ValidationError validate(Animal animal) {
        if (animal == null) {
            return new ValidationError(true, "Animal", "null animal");
        }

        if (animal.age() < 0 || animal.age() > 1000) {
            return new ValidationError(true, "age", "unreal age");
        }

        return new ValidationError(false, "", "success");
    }
}
