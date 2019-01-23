package search.arrayList;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        int indexOfList = 0;
        for (int[] a : array) {
            int count = 0;
            for (int t : a) {
                if (count != a.length) {
                    list.add(indexOfList++, t);
                    count++;
                } else {
                    break;
                }
            }
        }

        return list;
    }
}
