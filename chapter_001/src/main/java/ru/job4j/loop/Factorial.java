package ru.job4j.loop;

/**
 * Класс высчитывает факториал числа.
 */
public class Factorial {

    /**
     * Метод, который считает факториал числа.
     * @param n - число факториал которого нужно посчитать.
     * @return - итоговое значение факториала.
     */
    public int calc(int n) {
        int factorial = 1; //Переменная в которую будем записывать результат.

        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
