package ru.job4j.strategy;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SquareTest {
    @Test
    public void whenDrawSquare() {
        String ln = System.lineSeparator();
        Square square = new Square();
        assertThat(square.draw(),
                is(
                        new StringBuilder()
                                .append("*****").append(ln)
                                .append("*****").append(ln)
                                .append("*****")
                                .toString()
                )
        );
    }
}
