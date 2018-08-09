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
     */
    public String[] remove(String[] array) {
        int unique = array.length; //Переменная, которая приравнена к длине массива.
        for (int out = 0; out < unique; out++) { //Берем первый элемент массива.
            for (int in = out + 1; in < unique; in++) { //Начинаем сравнивать со следующего элемента.
                if (array[out].equals(array[in])) { //Если элементы равны, то
                    array[in] = array[unique - 1]; //заменяем второй элемент последним.
                    unique--; //Уменьшаем длину массива.
                    in--; //Опять сравниваем первое число со вторым.
                    // Если вдруг последнее совпадает со сравниваемым.
                }
            }
        }
        return Arrays.copyOf(array, unique); //Выводим массив получившейся длины.
    }
}
