package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {
    @Test
    public void when2on2() {
        Matrix matrix = new Matrix();
        int[][] result = matrix.multiple(2);
        int[][] expected = {
                {1, 2},
                {2, 4}
        };
        assertThat(result, is(expected));
    }

    @Test
    public void when4on4() {
        Matrix matrix = new Matrix();
        int[][] result = matrix.multiple(4);
        int[][] expected = {
                {1, 2, 3, 4},
                {2, 4, 6, 8},
                {3, 6, 9, 12},
                {4, 8, 12, 16}
        };
        assertThat(result, is(expected));
    }
}
