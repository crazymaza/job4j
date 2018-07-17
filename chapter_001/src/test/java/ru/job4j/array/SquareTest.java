package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SquareTest {
    @Test
    public void whenBound3Then149() {
        int bound = 3;
        Square square = new Square();
        int[] result = square.calculate(bound);
        int[] expected = new int[]{1, 4, 9};
        assertThat(result, is(expected));
    }

    @Test
    public void whenBoundFiveThen1491625() {
        int bound = 5;
        Square square = new Square();
        int[] result = square.calculate(bound);
        int[] expected = new int[]{1, 4, 9, 16, 25};
        assertThat(result, is(expected));
    }

    @Test
    public void whenBoundZero() {
        int bound = 0;
        Square square = new Square();
        int[] result = square.calculate(bound);
        int[] expected = new int[0];
        assertThat(result, is(expected));
    }
}
