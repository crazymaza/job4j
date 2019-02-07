package search.user;

import java.util.*;

public class SortUser {

    /**
     * В этом методе происходит сортировка пользователей методом compareTo,
     * объявленным в классе User.
     *
     * @param unsorted - несортированная коллекция.
     * @return - сортированный TreeSet.
     */
    public Set<User> sort(List<User> unsorted) {
        return new TreeSet<>(unsorted);
    }

    /**
     * Здесь происходит сортировка с помощью компаратора.
     * Сортируются пользователи по длине имени.
     *
     * @param users - коллекция пользователей.
     * @return - коллекция после сортировки.
     */
    public List<User> sortNameLength(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        });
        return users;
    }

    /**
     * Здесь сортируем по имени, а потом по возрасту,
     * если имена одинаковые.
     *
     * @param users - коллекция пользователей.
     * @return - отсортированная коллекция пользователей.
     */
    public List<User> sortByAllFields(List<User> users) {
        users.sort(new Comparator<User>() {
            int result = 0;

            @Override
            public int compare(User o1, User o2) {
                for (int i = 0; i < o1.getName().length(); i++) {
                    result = o1.getName().charAt(i) - o2.getName().charAt(i);
                    if (result != 0) {
                        break;
                    }
                }
                if (result == 0) {
                    result = o1.getAge() - o2.getAge();
                }
                return result;
            }
        });
        return users;
    }
}
