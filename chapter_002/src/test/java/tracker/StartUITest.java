package tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    /**
     * Как работает данный тип теста:
     * Создаём Tracker, затем создаём StubInput с последовательностью действий.
     * После этого создаём StartUI и вызываем метод init().
     * И в завершении проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        ConsoleInput input = new StubInput(new String[]{"1", "test name", "desc", "0"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test name"));
    }

    /**
     * Как работает данный тип теста:
     * Создаём Tracker, затем создаём StubInput с последовательностью действий(производим нужные нам действия).
     * После этого создаём StartUI и вызываем метод init().
     * И в завершении проверяем, получилось ли у нас верно произвести действия над элементом.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        ConsoleInput input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "0"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Item item1 = tracker.add(new Item("test1", "desc"));
        ConsoleInput input = new StubInput(new String[]{"3", item.getId(), "Y", "0"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0], is(item1));
    }

    @Test
    public void whenFindItemById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        ConsoleInput input = new StubInput(new String[]{"6", item.getId(), "0"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()), is(item));
    }

}
