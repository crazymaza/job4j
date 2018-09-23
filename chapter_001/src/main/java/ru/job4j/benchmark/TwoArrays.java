package ru.job4j.benchmark;

/**
 * Есть два отсортированных по возрастанию массива чисел.
 * Нужно проверить, что они отсортированы
 * и, если это верно, то добавить их значения в третий массив.
 * Третий массив тоже должен быть отсортирован.
 */
public class TwoArrays {
    /**
     * Метод, который осуществляет сортировку
     * Сортировка происходит по методу
     * "Сортировка слиянием".
     *
     * @param first - первый массив.
     * @param second - второй массив.
     * @return - итоговый массив.
     * {@value} result - Создание итогового массива.
     * {@value} lenFirstArray - Создание переменной, равной длине первого массива.
     * {@value} lenSecondArray - Создание переменной, равной длине второго массива.
     * {@value} one и {@value} two - Переменные-итерации по массивам.
     * В цикле for мы сравниваем если one и two меньше длины соответствующих массивов, то:
     * дальше идет сравнение элементов. Если элемент в первом массиве больше элемента во втором массиве.
     * Заносим элемент в итоговый массив и инкреминируем переменную two.
     * В ином случае делаем тоже самое с элементом и переменной первого массива.
     * Затем смотрим если первый массив закончился, а второй еще нет.
     * Мы прибавляем элементы из массива в итоговый.
     * И если второй массив закончился, а первый еще нет.
     * Мы прибавляем элементы из массива в итоговый.
     */
    public int[] threeArrays(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int lenFirstArray = first.length;
        int lenSecondArray = second.length;
        int one = 0, two = 0;
        for (int i = 0; i < result.length; i++) {
            if (two < lenSecondArray && one < lenFirstArray) {
                if (first[one] > second[two]) {
                    result[i] = second[two++];
                } else {
                    result[i] = first[one++];
                }
            } else if (two < lenSecondArray) {
                result[i] = second[two++];
            } else {
                result[i] = first[one++];
            }
        }
        return result;
    }
}
