package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.List;

/**
 * В данном классе используем композицию.
 * Создали переменную типа Tracker и работаем через нее.
 */
public class TrackerSingletonComp {
    private Tracker tracker = new Tracker();
    private static TrackerSingletonComp ourInstance;

    /**
     * Здесь мы получаем экземпляр класса.
     * Если экземпляр уже есть, то мы не создаем новый,
     * а возвращаем тот, что есть.
     * Если экземпляр ранее не создавался, то создаем новый.
     *
     * @return возвращаем экземпляр класса.
     */
    public static TrackerSingletonComp getInstance() {
        if (ourInstance == null) {
            ourInstance = new TrackerSingletonComp();
        }
        return ourInstance;
    }

    /**
     * Приватный конструктор, чтобы нельзя было напрямую создать экземпляр класса.
     */
    private TrackerSingletonComp() {
    }

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
