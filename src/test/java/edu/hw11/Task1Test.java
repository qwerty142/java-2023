package edu.hw11;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    @Test
    public void testToStringOutPut() throws InstantiationException, IllegalAccessException {
        DynamicType.Unloaded<Object> type = new ByteBuddy()
            .subclass(Object.class)
            .method(ElementMatchers.isToString())
            .intercept(FixedValue.value("Hello, ByteBuddy!"))
            .make();

        Class<?> dynamic = type.load(Task1Test.class
                .getClassLoader())
            .getLoaded();
        assertThat(dynamic.newInstance().toString()).isEqualTo("Hello, ByteBuddy!");
    }
}
