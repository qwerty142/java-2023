package edu.hw4.Validators;

import edu.hw4.Animal;

public class ValidateWeight implements Validation {
    @SuppressWarnings("checkstyle:MagicNumber") @Override
    public ValidationError validate(Animal animal) {
        if (animal == null) {
            return new ValidationError(true, "animal", "null animal");
        }

        if (animal.weight() < 0 || animal.weight() > 100000) {
            return new ValidationError(true, "weight", "unreal weight");
        }

        return new ValidationError(false, "", "success");
    }
}
