package tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private PrintStream stdout = System.out;
    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    private Tracker tracker = new Tracker();
    private String ln = System.lineSeparator();
    private StringBuilder sb = new StringBuilder()
            .append("Меню:").append(ln)
            .append("1. Добавление заявки").append(ln)
            .append("2. Редактирование заявки").append(ln)
            .append("3. Удаление заявки").append(ln)
            .append("4. Получение списка всех заявок").append(ln)
            .append("5. Нахождение заявки по названию").append(ln)
            .append("6. Нахождение заявки по идентификатору(id)").append(ln)
            .append("0. Выход").append(ln);


    /**
     * Данный код выполняется перед запуском тестов.
     */
    @Before
    public void loadOutput() {
        System.out.println("Before tests");
        System.setOut(new PrintStream(this.out));
    }

    /**
     * Данный код выполняется после запуска тестов.
     */
    @After
    public void loadInput() {
        System.setOut(this.stdout);
        System.out.println("After tests");
    }

    /**
     * Как работает данный тип теста:
     * Создаём Tracker, затем создаём StubInput с последовательностью действий.
     * После этого создаём StartUI и вызываем метод init().
     * И в завершении проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
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
        Item item = tracker.add(new Item("test name", "desc"));
        ConsoleInput input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "0"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteItem() {
        Item item = tracker.add(new Item("test name", "desc"));
        Item item1 = tracker.add(new Item("test1", "desc"));
        ConsoleInput input = new StubInput(new String[]{"3", item.getId(), "Y", "0"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0], is(item1));
    }

    @Test
    public void whenFindItemById() {
        Item item = tracker.add(new Item("test name", "desc"));
        ConsoleInput input = new StubInput(new String[]{"6", item.getId(), "0"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(sb)
                                .append("------------ Поиск заявки по идентификатору(id) --------------")
                                .append(ln)
                                .append("Id заявки: ").append(item.getId()).append(ln)
                                .append("Название заявки: ").append(item.getName()).append(ln)
                                .append("Описание заявки: ").append(item.getDescription()).append(ln)
                                .append("-------------").append(ln)
                                .append(ln)
                                .append(sb)
                                .append("Уже уходите? Ну что ж, до скорой встречи!").append(ln)
                                .toString()
                )
        );
    }

    @Test
    public void whenTheUserChoseToViewAllApplications() {
        Item item = new Item("aaa", "aaa");
        tracker.add(item);
        ConsoleInput input = new StubInput(new String[]{"4", "0"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(sb)
                                .append("------------ Все имеющиеся заявки --------------").append(ln)
                                .append("Id заявки: ").append(item.getId()).append(ln)
                                .append("Название заявки: ").append(item.getName()).append(ln)
                                .append("Описание заявки: ").append(item.getDescription()).append(ln)
                                .append("-------------").append(ln)
                                .append(ln)
                                .append(sb)
                                .append("Уже уходите? Ну что ж, до скорой встречи!").append(ln)
                                .toString()
                )

        );
    }

    @Test
    public void whenFindItemByName() {
        Item item = new Item("aaa", "aaa");
        tracker.add(item);
        ConsoleInput input = new StubInput(new String[]{"5", item.getName(), "0"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(sb)
                                .append("------------ Поиск заявки по названию --------------").append(ln)
                                .append("Вот что удалось найти по названию ").append(item.getName())
                                .append(":").append(ln)
                                .append("Id заявки: ").append(item.getId()).append(ln)
                                .append("Название заявки: ").append(item.getName()).append(ln)
                                .append("Описание заявки: ").append(item.getDescription()).append(ln)
                                .append("-------------").append(ln)
                                .append(ln)
                                .append(sb)
                                .append("Уже уходите? Ну что ж, до скорой встречи!").append(ln)
                                .toString()
                )
        );
    }


}
