package edu.hw4.Validators;

import edu.hw4.Animal;

public interface Validation {
    ValidationError validate(Animal animal);
}
