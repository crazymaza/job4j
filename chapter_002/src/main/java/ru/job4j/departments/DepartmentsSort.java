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

    public String[] ascendingSort(String[] dep) {
        Arrays.sort(dep);
        return dep;
    }

    public String[] descendingSort(String[] dep) {
        String[] result;
        TreeSet<String> treeSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int compareResult = 0;
                int firstLength = o1.length();
                int secondLength = o2.length();
                if (firstLength == secondLength) {
                    compareResult = compareIndex(o1, o2);
                }
                if (firstLength > secondLength) {
                    if (o1.startsWith(o2)) {
                        compareResult = 1;
                    } else {
                        compareResult = compareIndex(o1, o2);
                    }
                }
                if (firstLength < secondLength) {
                    if (o2.startsWith(o1)) {
                        compareResult = -1;
                    } else {
                        compareResult = compareIndex(o1, o2);
                    }
                }
                return compareResult;
            }
        });
        treeSet.addAll(Arrays.asList(dep));
        result = treeSet.toArray(new String[0]);
        return result;
    }

    public int compareIndex(String o1, String o2) {
        int result = 0;
        int firstLength = o1.length();
        int secondLength = o2.length();
        int whoIsBigger = firstLength > secondLength ? secondLength : firstLength;
        for (int i = 0; i < whoIsBigger; i++) {
            if (o1.charAt(i) > o2.charAt(i)) {
                result = -1;
            }
            if (o1.charAt(i) < o2.charAt(i)) {
                result = 1;
            }
            if (o1.charAt(i) == o2.charAt(i)) {
                if (firstLength == whoIsBigger - 1) {
                    result = -1;
                }
                if (secondLength == whoIsBigger - 1) {
                    result = 1;
                }
            }
        }
        return result;
    }
}
