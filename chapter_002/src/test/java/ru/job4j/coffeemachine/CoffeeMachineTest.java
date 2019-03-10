package ru.job4j.coffeemachine;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoffeeMachineTest {
    private CoffeeMachine coffee = new CoffeeMachine();
    private PrintStream stdout = System.out;
    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    private String ln = System.lineSeparator();
    private StringBuilder sb = new StringBuilder()
            .append("Put more money!").append(ln);

    @Test
    public void whenTheValueIs100AndThePriceIs33() {
        int[] result = coffee.changes(100, 33);
        int[] expected = {10, 10, 10, 10, 10, 10, 5, 2};
        assertThat(result, is(expected));
    }

    @Test
    public void whenTheValueIs50AndThePriceIs33() {
        int[] result = coffee.changes(50, 33);
        int[] expected = {10, 5, 2};
        assertThat(result, is(expected));
    }

    @Test
    public void whenTheValueIs100AndThePriceIs17() {
        int[] result = coffee.changes(100, 17);
        int[] expected = {10, 10, 10, 10, 10, 10, 10, 10, 2, 1};
        assertThat(result, is(expected));
    }

    @Test
    public void whenTheValueIs50AndThePriceIs35() {
        int[] result = coffee.changes(50, 35);
        int[] expected = {10, 5};
        assertThat(result, is(expected));
    }

    @Test
    public void whenTheValueIs10AndThePriceIs17() {
        System.setOut(new PrintStream(this.out));
        coffee.changes(10, 17);
        assertThat(new String(out.toByteArray()),
                is(String.valueOf(sb))
        );
        System.setOut(this.stdout);
    }


}

