package edu.hw10;

import edu.hw10.Generators.DoubleGenerator;
import edu.hw10.Generators.GeneratorBase;
import edu.hw10.Generators.IntGenerator;
import edu.hw10.Generators.StringGenerator;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Comparator;

public class Task1 {
    private GeneratorBase generatorBase;

    public Task1() {
        GeneratorBase doubleGenerator = new DoubleGenerator();
        doubleGenerator.next = new IntGenerator();
        doubleGenerator.next.next = new StringGenerator();
        generatorBase = doubleGenerator;
    }

    public <T> T nextObject(Class<T> target)
        throws InvocationTargetException, InstantiationException, IllegalAccessException {
        var constructor = Arrays.stream(target.getDeclaredConstructors())
            .max(Comparator.comparingInt(Constructor::getParameterCount))
            .orElseThrow();
        constructor.setAccessible(true);
        return (T) constructor.newInstance(getArgs(constructor));
    }

    private Object[] getArgs(Executable method) {
        Parameter[] parameters = method.getParameters();
        Object[] args = new Object[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            args[i] = generatorBase.generateValue(parameters[i]);
        }

        return args;
    }
}
