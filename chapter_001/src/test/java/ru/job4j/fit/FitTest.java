package ru.job4j.fit;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class FitTest {
    private Fit fit = new Fit();

    @Test
    public void manWeight() {
        double result = fit.manWeight(180);
        double expected = 92;
        assertThat(result, closeTo(expected, 0.1));
    }

    @Test
    public void womanWeight() {
        double result = fit.womanWeight(180);
        double expected = 80.5;
        assertThat(result, closeTo(expected, 0.1));
    }
}
