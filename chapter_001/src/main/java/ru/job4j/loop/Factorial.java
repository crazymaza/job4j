package ru.job4j.loop;

/**
 * Класс высчитывает факториал числа.
 */
public class Factorial {

    /**
     * Метод, который считает факториал числа.
     * @param number - число факториал которого нужно посчитать.
     * @return - итоговое значение факториала.
     * {@value} factorial - Переменная в которую будем записывать результат.
     */
    public int calc(int number) {
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
