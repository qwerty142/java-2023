package edu.hw10.Generators;

import edu.hw10.Annotations.Max;
import edu.hw10.Annotations.Min;
import java.lang.reflect.Parameter;
import java.util.concurrent.ThreadLocalRandom;

public class DoubleGenerator extends GeneratorBase {
    @SuppressWarnings("checkstyle:InnerAssignment") @Override
    public Object generateValue(Parameter parameter) {
        if (parameter.getType().equals(Double.class) || parameter.getType().equals(double.class)) {
            var min = Double.MIN_VALUE;
            var max = Double.MAX_VALUE;
            for (var annotation : parameter.getAnnotations()) {
                switch (annotation) {
                    case Min m -> min = Double.parseDouble(m.value());
                    case Max m -> max = Double.parseDouble(m.value());
                    default -> {
                    }
                }
            }

            return ThreadLocalRandom.current().nextDouble(min, max);
        }

        return generateNext(parameter);
    }
}
