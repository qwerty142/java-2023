package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.assertj.core.api.Assertions.assertThat;

public class Task7Test {
    @Test
    public void NullFriendlyComparatorTest() {
        TreeMap<String, String> treeMap = new TreeMap<>(new Task7.NullFriendlyComparator());
        treeMap.put(null, "test");

        assertThat(treeMap.containsKey(null)).isTrue();
    }
}
