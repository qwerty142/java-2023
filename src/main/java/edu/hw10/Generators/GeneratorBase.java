package edu.hw10.Generators;

import java.lang.reflect.Parameter;

public abstract class GeneratorBase {
    public GeneratorBase next;

    public abstract Object generateValue(Parameter parameter);

    public Object generateNext(Parameter parameter) {
        if (next == null) {
            return null;
        }

        return next.generateValue(parameter);
    }
}
