package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @Test
    public void whenAddOnePlusOneThenTwo() {
        calculator.add(1,1);
        double result = calculator.getResult();
        double expected = 2;
        assertThat(result,is(expected));
    }

    @Test
    public void whenSubtractTwoOneThenOne() {
        calculator.subtract(2,1);
        double result = calculator.getResult();
        double expected = 1;
        assertThat(result,is(expected));
    }

    @Test
    public void whenFourDivOnTwoThenTwo() {
        calculator.div(4,2);
        double result = calculator.getResult();
        double expected = 2;
        assertThat(result,is(expected));
    }

    @Test
    public void whenTwoMultipleOnTwoThenFour() {
        calculator.multiple(2,2);
        double result = calculator.getResult();
        double expected = 4;
        assertThat(result,is(expected));
    }
}
