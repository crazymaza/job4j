package ru.job4j.benchmark;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TwoArraysTest {
    @Test
    public void whenTwoIdenticalArraysAreSortedIntoTheThirdArray() {
        TwoArrays arrays = new TwoArrays();
        int[] first = {1, 3, 4, 5, 7};
        int[] second = {2, 6, 8, 9, 10};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] result = arrays.threeArrays(first, second);
        assertThat(result, is(expected));
    }

    @Test
    public void whenTwoDifferentArraysAreSortedIntoTheThirdArray() {
        TwoArrays arrays = new TwoArrays();
        int[] first = {3, 4, 5, 7, 10, 11, 14};
        int[] second = {1, 2, 6, 8, 9, 12, 13, 15};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int[] result = arrays.threeArrays(first, second);
        assertThat(result, is(expected));
    }

    @Test
    public void whenTwoDifferentArraysAreSortedIntoTheThirdArray1() {
        TwoArrays arrays = new TwoArrays();
        int[] first = {3, 4, 5, 7, 9};
        int[] second = {1, 2, 6, 8};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] result = arrays.threeArrays(first, second);
        assertThat(result, is(expected));
    }

    @Test
    public void test() {
        TwoArrays arrays = new TwoArrays();
        int[] first = {};
        int[] second = {1, 2, 6, 8};
        int[] expected = {1, 2, 6, 8};
        int[] result = arrays.threeArrays(second, first);
        assertThat(result, is(expected));
    }
}
