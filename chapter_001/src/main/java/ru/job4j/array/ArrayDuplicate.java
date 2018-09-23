package ru.job4j.array;

import java.util.Arrays;

/**
 * Класс в котором удаляются дубликаты из массива.
 */
public class ArrayDuplicate {
    /**
     * Метод который просматривает массив и удаляет из него дубликаты.
     *
     * @param array -входящий массив с дубликатами.
     * @return - массив без дубликатов.
     * {@value} unique - Переменная, которая приравнена к длине массива.
     * В цикле for берем первый элемент массива и начинаем сравнивать со следующего элемента.
     * Если элементы равны, то заменяем второй элемент последним.
     * Уменьшаем длину массива.
     * Опять сравниваем первое число со вторым.
     * in-- Если вдруг последнее совпадает со сравниваемым.
     */
    public String[] remove(String[] array) {
        int unique = array.length;
        for (int out = 0; out < unique; out++) {
            for (int in = out + 1; in < unique; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[unique - 1];
                    unique--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }
}
