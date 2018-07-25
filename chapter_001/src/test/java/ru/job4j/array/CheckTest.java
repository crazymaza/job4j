package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CheckTest {
    @Test
    public void whenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] arr = {true, true, true};
        boolean result = check.mono(arr);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataMonoByTrueThenFalse() {
        Check check = new Check();
        boolean[] arr = {true, false, true};
        boolean result = check.mono(arr);
        assertThat(result, is(false));
    }

    @Test
    public void whenDataMonoByFalseThenTrue() {
        Check check = new Check();
        boolean[] arr = {false, false, false};
        boolean result = check.mono(arr);
        assertThat(result, is(true));
    }
}
