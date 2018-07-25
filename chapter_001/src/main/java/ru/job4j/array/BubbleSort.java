package ru.job4j.array;

public class BubbleSort {
    /**
     * Сортировка массива методом пузырька.
     *
     * @param array - массив для сортировки.
     * @return - отсортированный массив.
     */
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
