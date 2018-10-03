package tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * Класс в котором происходит основная логика программы добавления-удаления заявки.
 */
public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;
    private final static Random RANDOM = new Random();

    public int getPosition() {
        return position;
    }

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
        item.setId(id);
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
            position--;
        }
    }

    /**
     * В данном методе мы получаем массив существующих заявок.
     *
     * @return - массив существующих заявок.
     */
    public Item[] getAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    /**
     * Метод в котором ищем заявки по имени.
     *
     * @param name - имя заявки.
     * @return - массив найденых заявок.
     */
    public Item[] findByName(String name) {
        int count = 0;
        Item[] resultArray = new Item[position];
        for (int index = 0; index != position; index++) {
            if (items[index] != null && items[index].getName().equals(name)) {
                resultArray[count] = items[index];
                count++;
            }
        }
        return Arrays.copyOf(resultArray, count);
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
