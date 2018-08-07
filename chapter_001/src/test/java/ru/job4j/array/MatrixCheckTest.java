package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixCheckTest {
    @Test
    public void whenDataMonoByTrueThenTrue() {
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean[][] input = {
                {true, false, true},
                {false, true, false},
                {true, false, true}
        };
        boolean result = matrixCheck.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataMonoByTrueThenFalse() {
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean[][] input = {
                {true, false, true},
                {false, false, false},
                {true, false, true}
        };
        boolean result = matrixCheck.mono(input);
        assertThat(result, is(false));
    }

    @Test
    public void whenDataMonoHaveTwoElementsByTrueThenTrue() {
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean[][] input = {
                {true, false},
                {false, true}
        };
        boolean result = matrixCheck.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataMonoHaveTwoElementsByTrueThenFalse() {
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean[][] input = {
                {true, false},
                {false, false}
        };
        boolean result = matrixCheck.mono(input);
        assertThat(result, is(false));
    }
}
