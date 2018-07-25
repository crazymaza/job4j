package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void whenArrayNotSortedThenSorted() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = {1, 3, 6, 2, 5, 7, 9, 8, 10, 4};
        int[] result = bubbleSort.sort(arr);
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertThat(result, is(expected));
    }
}
