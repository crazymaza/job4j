package search.arraylist;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] a : array) {
            for (int t : a) {
                list.add(t);
            }
        }
        return list;
    }
}
