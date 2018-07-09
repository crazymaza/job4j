package ru.job4j.loop;

/**
 * Класс высчитывает факториал числа.
 */
public class Factorial {

    /**
     * Переменная в которой будет сохраняться значение.
     * Она равна 1, потому что умножение на 0 = 0.
     */
    int factorial = 1;

    /**
     * Метод, который считает факториал числа.
     * @param n - число факториал которого нужно посчитать.
     * @return - итоговое значение факториала.
     */
    public int calc(int n) {
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
