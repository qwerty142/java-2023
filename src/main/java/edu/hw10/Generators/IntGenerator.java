package edu.hw10.Generators;

import edu.hw10.Annotations.Max;
import edu.hw10.Annotations.Min;
import java.lang.reflect.Parameter;
import java.util.concurrent.ThreadLocalRandom;

public class IntGenerator extends GeneratorBase {

    @SuppressWarnings("checkstyle:InnerAssignment") @Override
    public Object generateValue(Parameter parameter) {
        if (parameter.getType().equals(Integer.class) || parameter.getType().equals(int.class)) {
            var minValue = Integer.MIN_VALUE;
            var maxValue = Integer.MAX_VALUE;
            for (var annotation : parameter.getAnnotations()) {
                switch (annotation) {
                    case Min an -> minValue = Integer.parseInt(an.value());
                    case Max an -> maxValue = Integer.parseInt(an.value());
                    default -> {
                    }
                }
            }

            return ThreadLocalRandom.current().nextInt(minValue, maxValue);
        }

        return generateNext(parameter);
    }
}
