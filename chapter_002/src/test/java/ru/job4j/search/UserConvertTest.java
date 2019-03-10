package ru.job4j.search;

import org.junit.Test;
import ru.job4j.search.map.User;
import ru.job4j.search.map.UserConvert;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenUserFromListConvertToMap() {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "Olga", "Moscow"));
        list.add(new User(2, "Anna", "Moscow"));
        UserConvert userConvert = new UserConvert();
        userConvert.process(list);
        String result = userConvert.process(list).get(2).getName();
        assertThat(result, is("Anna"));
    }
}
