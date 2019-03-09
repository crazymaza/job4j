package search;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int min = Math.min(left.length(),right.length());
        int result = 0;
        for (int index = 0; index < min && result == 0; index++) {
             result = Character.compare(left.charAt(index),right.charAt(index));
        }
        if (result == 0) {
            result = Integer.compare(left.length(),right.length());
        }
        return result;
    }
}