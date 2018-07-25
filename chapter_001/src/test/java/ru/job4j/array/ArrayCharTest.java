package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayCharTest {
    @Test
    public void whenStartWithPrefixThenTrue() {
        ArrayChar arrayChar = new ArrayChar("Hello");
        boolean result = arrayChar.startWith("He");
        assertThat(result, is(true));
    }

    @Test
    public void whenStartWithPrefixThenFalse() {
        ArrayChar arrayChar = new ArrayChar("Hello");
        boolean result = arrayChar.startWith("Hi");
        assertThat(result, is(false));
    }
}
