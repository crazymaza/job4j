package search.arraylist;

import java.util.List;

/**
 * Внутри методов использовать foreach.
 * <p>
 * public int[][] toArray (List<Integer> list, int rows) {} - метод toArray должен
 * равномерно разбить лист на количество строк двумерного массива.
 * В методе toArray должна быть проверка - если количество элементов
 * не кратно количеству строк - оставшиеся значения в массиве заполнять нулями.
 * <p>
 * Например в результате конвертации листа со значениями (1,2,3,4,5,6,7)
 * с разбиением на 3 строки должен получиться двумерный массив {{1, 2, 3} {4, 5, 6} {7, 0 ,0}}
 */
public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells;
        if (list.size() % rows != 0) {
            cells = (list.size() / rows) + 1;
        } else {
            cells = list.size() / rows;
        }
        int[][] array = new int[rows][cells];
        int indexOfList = 0;
        for (int[] i : array) {
            int count = 0;
            for (int t : i) {
                if (indexOfList < list.size()) {
                    i[count++] = list.get(indexOfList++);
                }
            }
        }
        return array;
    }
}
