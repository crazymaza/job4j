package search;

import org.junit.Test;
import search.user.SortUser;
import search.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenSortedUserByAge() {
        List<User> unsorted = new ArrayList<>();
        unsorted.add(new User("Vava", 12));
        unsorted.add(new User("Dada", 110));
        unsorted.add(new User("Papa", 1900));
        unsorted.add(new User("Mama", 10));
        SortUser user = new SortUser();
        user.sort(unsorted);
        TreeSet<User> sorted = new TreeSet<>(user.sort(unsorted));
        int result = sorted.first().getAge();
        assertThat(result, is(10));
    }

    @Test
    public void whenSortedUserByNameLength() {
        List<User> unsorted = new ArrayList<>();
        unsorted.add(new User("Vavara", 12));
        unsorted.add(new User("Dadarada", 110));
        unsorted.add(new User("Papaonkae", 1900));
        unsorted.add(new User("Mama", 10));
        SortUser user = new SortUser();
        user.sort(user.sortNameLength(unsorted));
        int result = unsorted.get(0).getAge();
        assertThat(result, is(10));
    }
    @Test
    public void whenSortedUserByNameAndAge() {
        List<User> unsorted = new ArrayList<>();
        unsorted.add(new User("Иван", 12));
        unsorted.add(new User("Иван", 110));
        unsorted.add(new User("Сергей", 1900));
        unsorted.add(new User("Сергей", 10));
        SortUser user = new SortUser();
        user.sort(user.sortByAllFields(unsorted));
        int result = unsorted.get(2).getAge();
        assertThat(result, is(10));
    }
}
