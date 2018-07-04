package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whoIsBiggest() {
        Max maximum = new Max();
        int result = maximum.max(1, 2);
        int expected = 2;
        assertThat(result, is(expected));
    }
}
