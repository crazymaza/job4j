package ru.job4j.benchmark;

/**
 *Есть два отрезка на одной прямой. ab и cd.
 * а > b & c < d
 * Нужно найти условие при котором они пересекаются.
 */
public class TwoSegments {
    /**
     * Метод, который вычисляет пересечение отрезков.
     * @param arr1 - массив точек отрезков. arr1[0] - a, arr1[1] - b, arr1[2] - c, arr1[3] - d.
     * @return - ответ пересекаются или нет.
     */
    public boolean beOrNot(int[] arr1) {
        boolean result = false;
        if (arr1[1] < arr1[2] && arr1[0] > arr1[2]
                || arr1[1] > arr1[2] && arr1[0] > arr1[3]
                || arr1[1] < arr1[2] && arr1[0] < arr1[3]) {
            result = true;
        }
        return result;
    }
}
