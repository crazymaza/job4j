package ru.job4j.benchmark;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TwoArraysTest {
    @Test
    public void whenTwoIdenticalArraysAreSortedIntoTheThirdArray() {
        TwoArrays arrays = new TwoArrays();
        int[] arr1 = {1, 3, 4, 5, 7};
        int[] arr2 = {2, 8, 6, 9, 10};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] result = arrays.threeArrays(arr1, arr2);
        assertThat(result, is(expected));
    }

    @Test
    public void whenTwoDifferentArraysAreSortedIntoTheThirdArray() {
        TwoArrays arrays = new TwoArrays();
        int[] arr1 = {10, 3, 4, 5, 7, 11, 14};
        int[] arr2 = {8, 1, 9, 6, 2, 12, 13, 15};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int[] result = arrays.threeArrays(arr1, arr2);
        assertThat(result, is(expected));
    }

    @Test
    public void whenTwoDifferentArraysAreSortedIntoTheThirdArray1() {
        TwoArrays arrays = new TwoArrays();
        int[] arr1 = {9, 3, 4, 5, 7};
        int[] arr2 = {8, 1, 6, 2};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] result = arrays.threeArrays(arr1, arr2);
        assertThat(result, is(expected));
    }
}
