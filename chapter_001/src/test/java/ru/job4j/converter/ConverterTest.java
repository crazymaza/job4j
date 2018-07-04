package ru.job4j.converter;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConverterTest {
    private Converter converter = new Converter();

    @Test
    public void whenRubToEur() {
        int result = converter.rubToEur(140);
        int expected = 2;
        assertThat(result, is(expected));
    }

    @Test
    public void whenRubToUsd() {
        int result = converter.rubToUsd(120);
        int expected = 2;
        assertThat(result, is(expected));
    }

    @Test
    public void whenEurToRub() {
        int result = converter.eurToRub(2);
        int expected = 140;
        assertThat(result, is(expected));
    }

    @Test
    public void whenUsdToRub() {
        int result = converter.usdToRub(2);
        int expected = 120;
        assertThat(result, is(expected));
    }

    @Test
    public void whenUsdToEur() {
        double result = converter.usdToEur(10);
        double expected = 6;
        assertThat(result, is(expected));
    }

}
