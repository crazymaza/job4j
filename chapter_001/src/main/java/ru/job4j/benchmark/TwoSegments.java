package ru.job4j.benchmark;

/**
 *Есть два отрезка на одной прямой. ab и cd.
 * а > b & c < d
 * Нужно найти условие при котором они пересекаются.
 */
public class TwoSegments {
    /**
     * Метод, который вычисляет пересечение отрезков.
     * @param array - массив точек отрезков. array[0] - a, array[1] - b, array[2] - c, array[3] - d.
     * @return - ответ пересекаются или нет.
     */
    public boolean beOrNot(int[] array) {
        boolean result = false;
        if (array[1] < array[2] && array[0] > array[2]
                || array[1] > array[2] && array[0] > array[3]
                || array[1] < array[2] && array[0] < array[3]) {
            result = true;
        }
        return result;
    }
}
