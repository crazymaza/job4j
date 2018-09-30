package tracker;

import java.util.Random;

/**
 * Класс в котором происходит основная логика программы добавления-удаления заявки.
 */
public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;
    private final static Random RANDOM = new Random();

    /**
     * Метод, который добалвяет элемент в массив.
     *
     * @param item - элемент, который нам нужно добавить.
     * @return - добавление элемента.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
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
     */
    public void replace(String id, Item item) {
        for (int index = 0; index != items.length; index++) {
            if (items[index].getId().equals(id)) {
                items[index] = item;
                break;
            }
        }
    }

    /**
     * Метод, который удаляет элемент из массива(трекера)
     *
     * @param id - уникальный номер элемента.
     */
    public void delete(String id) {
        for (int index = 0; index != items.length; index++) {
            if (items[index].getId().equals(id)) {
                System.arraycopy(this.items, index + 1, this.items, index, position--);
                break;
            }
        }
    }

    /**
     * В данном методе мы получаем массив существующих заявок.
     *
     * Цикл for можно заменить методом System.arrayCopy();
     * @return - массив существующих заявок.
     */
    public Item[] getAll() {
        Item[] result = new Item[position];
        for (int index = 0; index < position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    /**
     * Метод в котором ищем заявки по имени.
     *
     * @param key - имя заявки.
     * @return - массив найденых заявок.
     */
    public Item[] findByName(String key) {
        int count = 0;
        for (int index = 0; index != items.length; index++) {
            if (items[index] != null && items[index].getName().equals(key)) {
                count++;
            }
        }
        Item[] resultArray = new Item[count];
        int unique = 0;
        for (int index = 0; index != position; index++) {
            if (items[index] != null && items[index].getName().equals(key)) {
                resultArray[unique++] = items[index];
            }
        }
        return resultArray;
    }

    /**
     * Метод с помощью которого можем найти элемент по уникальному идентификатору.
     *
     * @param id - идентификатор элемента, который мы ищем.
     * @return - искомый элемент.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item element : items) {
            if (element.getId().equals(id)) {
                result = element;
                break;
            }
        }
        return result;
    }
}
