package edu.hw10.Generators;

import edu.hw10.Annotations.NotNull;
import java.lang.reflect.Parameter;
import java.util.concurrent.ThreadLocalRandom;

public class StringGenerator extends GeneratorBase {
    private final String[] words = {
        "abaca",
        "hjfke",
        "zxcvb"
    };

    @Override
    public Object generateValue(Parameter parameter) {
        if (parameter.getType().equals(String.class)) {
            for (var annotation : parameter.getAnnotations()) {
                if (annotation instanceof NotNull) {
                    return "NotNull";
                }
            }

            return ThreadLocalRandom.current().nextBoolean()
                ? words[ThreadLocalRandom.current().nextInt(0, 2)]
                : null;
        }

        return generateNext(parameter);
    }
}
