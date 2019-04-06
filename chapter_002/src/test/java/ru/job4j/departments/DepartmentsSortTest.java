package ru.job4j.departments;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DepartmentsSortTest {

    @Test
    public void ascendingSortTest() {
        String[] departments = {
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K2\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1",
                "K2"
        };
        String[] expected = {
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK2",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };
        DepartmentsSort departmentSorter = new DepartmentsSort();
        String[] result = departmentSorter.ascendingSort(departments);
        assertThat(result, is(expected));
    }

    @Test
    public void descendingSortTest() {
        String[] departments = {
                "K2\\SK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K1",
                "K2\\SK1\\SSK2",
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1"
        };
        String[] expected = {
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1"
        };
        DepartmentsSort departmentSorter = new DepartmentsSort();
        String[] result = departmentSorter.descendingSort(departments);
        assertThat(result, is(expected));
    }
}
