package edu.hw10;

import edu.hw10.Annotations.Max;
import edu.hw10.Annotations.Min;
import edu.hw10.Annotations.NotNull;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import static org.assertj.core.api.Assertions.assertThat;

public class RandomObjectGeneratorTest {
    private class ClassWithMoreThanOneConstructors {
        public final double aDouble;
        public final int anInt;
        public final String aStr;

        public ClassWithMoreThanOneConstructors (@Max("5.4") double val) {
            aDouble = val;
            anInt = 0;
            aStr = "";
        }

        public ClassWithMoreThanOneConstructors(
            @Max("5.0") double dVal,
            @Min("1") @Max("3") int iVal,
            @NotNull String sVal
        ) {
            aDouble = dVal;
            anInt = iVal;
            aStr = sVal;
        }
    }

    @Test
    public void testWorkOfRandObjGenerator()
        throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Task1 rog = new Task1();

        var result = rog.nextObject(ClassWithMoreThanOneConstructors.class);

        assertThat(result.aStr).isNotNull();
        assertThat(result.aDouble).isLessThanOrEqualTo(5.4);
        assertThat(result.anInt).isBetween(1, 3);
    }
}
