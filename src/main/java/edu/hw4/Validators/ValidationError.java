package edu.hw4.Validators;

public record ValidationError(boolean hasError, String name, String error) {
}
