package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardTest {

    @Test
    public void whenTheChessBoardIsThreeByThree() {
        Board board = new Board();
        String result = board.paint(3, 3);
        String ln = System.lineSeparator();
        String expected = String.format("X X%s X %sX X%s", ln, ln, ln);
        assertThat(result, is(expected));
    }

    @Test
    public void whenTheChessBoardIsFiveByFive() {
        Board board = new Board();
        String result = board.paint(5, 4);
        String ln = System.lineSeparator();
        String expected = String.format("X X X%s X X %sX X X%s X X %s", ln, ln, ln, ln);
        assertThat(result, is(expected));
    }
}
