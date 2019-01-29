package tracker.singleton;

import tracker.Item;
import tracker.Tracker;

import java.util.List;

/**
 * Данный класс сделан в виде enum, т.е. экземпляр класса будет создаваться напрямую обращаясь к
 * переменной enum.
 */
public enum TrackerSingleEnum {
    TRACKER_SINGLE_ENUM;
    private Tracker tracker = new Tracker();

    /**
     * Добавление записи в тракер.
     * В методе мы через готовый класс тракер создаем запись.
     *
     * @param item - получаем запись.
     * @return - готовую запись.
     */
    public Item add(Item item) {
        return this.tracker.add(item);
    }

    /**
     * @return возвращает все элементы массивы.
     */
    public List<Item> getAll() {
       return this.tracker.getAll();
    }
}
