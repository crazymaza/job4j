package search.map;

import java.util.HashMap;
import java.util.List;

/**
 * В этом методе мы получаем на вход коллекцию пользователей в виде List,
 * а затем переводим её в HashMap, ключ = id пользователя.
 */
public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> integerUserMap = new HashMap<>();
        for (User user : list) {
            integerUserMap.put(user.getId(), user);
        }
        return integerUserMap;
    }
}
