package ru.job4j.array;

public class MatrixCheck {

    /**
     * Метод принимает параметром массив булевых значений и смотрит
     * значения по диагоналям.
     * @param data - массив булевых значений.
     * @return - Результат: true - если по диагоналям одинаковые значения,
     * в противном случае получаем false.
     * В методе for проходимся по матрице(двумерному массиву).
     * Так как главная диагональ это 0:0 1:1 2:2, то сравниваем эти значения.
     * Побочная диагональ это в обратную сторону от длины массива.
     * Если один из методов сравнения выдает нам false, то результат false.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            if (!(data[0][0] == data[i][i]) || !(data[(data.length - 1) - i][i]
                    == data[i][(data.length - 1) - i])) {
                result = false;
            }
        }
        return result;
    }
}
