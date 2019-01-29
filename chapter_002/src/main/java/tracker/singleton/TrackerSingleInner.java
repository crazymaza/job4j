package tracker.singleton;

import tracker.Item;
import tracker.Tracker;

import java.util.List;

/**
 * В этом классе мы используем статический внутренний класс в котором создаем экземпляр родительского класса.
 * Получить этот экземпляр мы можем с помощью метода getInstance();
 */
public class TrackerSingleInner {
    private Tracker tracker = new Tracker();

    private TrackerSingleInner() {
    }

    public static TrackerSingleInner getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerSingleInner INSTANCE = new TrackerSingleInner();
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
