package edu.hw4.Validators;

import edu.hw4.Animal;

public class ValidateHeight implements Validation {
    @SuppressWarnings({"checkstyle:MagicNumber"}) @Override
    public ValidationError validate(Animal animal) {
        if (animal == null) {
            return new ValidationError(true, "Animal", "Null animal");
        }

        if (animal.height() < 0 || animal.height() > 1000000) {
            return new ValidationError(true, "height", "Height is unreal");
        }

        return new ValidationError(false, "", "success");
    }
}
