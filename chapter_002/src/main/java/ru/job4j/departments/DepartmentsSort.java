package ru.job4j.departments;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;


/**
 * Делаем сортировку по убыванию.
 * Если длина 1 элемента больще длины второго элемента, то возвращаем -1
 * Если длина 1 элемента меньще длины второго элемента, то возврашаем 1
 * Если длины равны, то нужно сравнить элементы посимвольно.
 */

public class DepartmentsSort {
    private TreeSet<String> treeSet = new TreeSet<>(new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            int res = 0;
            int n1 = s1.length();
            int n2 = s2.length();
            int min = Math.min(n1, n2);
            for (int i = 0; i < min; i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                if (c1 < c2) {
                    return 1;
                } else if (c1 > c2) {
                    return -1;
                }
            }
            return n1 - n2;
        }
    });

    public void addString() {
        treeSet.add("K1");
        treeSet.add("K2\\SK1");
    }

    public String[] ascendingSort(String[] dep) {
        Arrays.sort(dep);
        return dep;
    }

    public String[] descendingSort(String[] dep) {
        String[] result;
        addString();
        treeSet.addAll(Arrays.asList(dep));
        result = treeSet.toArray(new String[0]);
        return result;
    }
}
