package search.user;

import java.util.*;

public class SortUser {


    public Set<User> sort(List<User> unsorted) {
        return new TreeSet<>(unsorted);
    }

    public List<User> sortNameLength(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        });
        return users;
    }

    public List<User> sortByAllFields (List<User> users) {
        users.sort(new Comparator<User>() {
            int result = 0;
            @Override
            public int compare(User o1, User o2) {
                result = ;
                if (result == 0) {
                    result = o1.getAge() - o2.getAge();
                }
                return result;
            }
        });
        return users;
    }
}
