package ru.job4j.loop;

/**
 * Класс, который вычисляет сумму всех
 * чётных чисел из указанного диапазона.
 */
public class Counter {

    /**
     * Временная переменная
     * в которую будет записана сумма чисел.
     */
    private int sum;

    /**
     * Метод, который подсчитывает сумму чётных чисел
     * из указанного диапазона.
     * @param first - начальное число.
     * @param last - конечное число.
     * @return - сумма всех чётных чисел из диапазона.
     */
    public int add(int first, int last) {
        for (int i = first; i <= last; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
