package ru.job4j.max;

/**
 * Класс, вычисляющий максимальное из двух чисел.
 */
public class Max {

    /**
     * Вычисляет максимальное число.
     * @param first - первое число.
     * @param second - второе число.
     * @return - возвращает максимальное число.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
}
