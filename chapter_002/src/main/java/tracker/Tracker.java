package tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Класс в котором происходит основная логика программы добавления-удаления заявки.
 * {value} items - массив заявок.
 * {value} position - сколько заявок в массиве.
 * {value} RANDOM - случайное число из диапазона, которое добавляется к id заявки.
 */
public class Tracker {
    private List<Item> items = new ArrayList<>();
    private int position;
    private final static Random RANDOM = new Random();

    /**
     * Метод, который добалвяет элемент в массив.
     *
     * @param item - элемент, который нам нужно добавить.
     * @return - добавление элемента.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }


    /**
     * Метод, который генерирует уникальный id добавляемому элементу.
     * Мы берем точное время в миллисекундах и добавляем к нему случайное число из установленного диапазона.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RANDOM.nextInt(100));
    }

    /**
     * Метод, который заменяет старую заявку на новую.
     *
     * @param id   - уникальный номер заменяемой заявки.
     * @param item - новая заявка.
     *             {value} result - если поменялось значение значит элемент был удален.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        item.setId(id);
        int count = 0;
        for (Item i : items) {
            if (i.getId().equals(id)) {
                items.set(count, item);
                result = true;
                break;
            }
            count++;
        }
        return result;
    }

    /**
     * Метод, который удаляет элемент из массива(трекера)
     *
     * @param id - уникальный номер элемента.
     *           {value} result - если поменялось значение значит элемент был удален.
     */
    public boolean delete(String id) {
        boolean result = false;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                items.remove(item);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * В данном методе мы получаем массив существующих заявок.
     *
     * @return - массив существующих заявок.
     */
    public List<Item> getAll() {
        return items.subList(0, items.size());
    }

    /**
     * Метод в котором ищем заявки по имени.
     *
     * @param name - имя заявки.
     * @return - массив найденых заявок.
     * {value} count - счетчик найденных элементов.
     */
    public List<Item> findByName(String name) {
        List<Item> nameList = new ArrayList<>();
        for (Item item : items) {
            if (item != null && item.getName().equals(name)) {
                nameList.add(item);
            }
        }
        return nameList.subList(0, nameList.size());
    }

    /**
     * Метод с помощью которого можем найти элемент по уникальному идентификатору.
     *
     * @param id - идентификатор элемента, который мы ищем.
     * @return - искомый элемент.
     * {value} result - переменной присваиваем значение найденного элемента.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}
