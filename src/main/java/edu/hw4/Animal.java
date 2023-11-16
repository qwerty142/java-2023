package edu.hw4;

import edu.hw4.Validators.Validation;
import edu.hw4.Validators.ValidationError;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record Animal(
    String name,
    Type type,
    Sex sex,
    int age,
    int height,
    int weight,
    boolean bites
) {
    enum Type {
        CAT, DOG, BIRD, FISH, SPIDER
    }

    enum Sex {
        M, F
    }

    @SuppressWarnings("checkstyle:MagicNumber")
    public int paws() {
        return switch (type) {
            case CAT, DOG -> 4;
            case BIRD -> 2;
            case FISH -> 0;
            case SPIDER -> 8;
        };
    }

    public Set<ValidationError> validating(List<Validation> validations) {
        Set<ValidationError> validationErrors = new HashSet<>();
        for (var validator : validations) {
            ValidationError curError = validator.validate(this);
            if (curError.hasError()) {
                validationErrors.add(curError);
            }
        }
        return validationErrors;
    }
}
