package search.user;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {


    public Set<User> sort(List<User> unsorted) {
        return new TreeSet<>(unsorted);
    }
}
