package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenWeRemoveDuplicateNamesFromAnArray() {
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] input = {"Ally", "Anna", "Ally", "Mia"};
        String[] output = {"Ally", "Anna", "Mia"};
        String[] result = duplicate.remove(input);
        assertThat(result, arrayContainingInAnyOrder(output));
    }

    @Test
    public void whenWeRemoveDuplicateNumbersFromAnArray() {
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] input = {"1", "1", "2", "2"};
        String[] output = {"1", "2"};
        String[] result = duplicate.remove(input);
        assertThat(result, arrayContainingInAnyOrder(output));
    }
}
