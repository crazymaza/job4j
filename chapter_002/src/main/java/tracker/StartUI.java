package tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс в котором мы запускаем программу и
 * в котором происходит вызов всех методов программы.
 * <p>
 * {value} ADD - константа, пункт меню, относится к методу добавления заявки.
 * {value} REPLACE - константа, пункт меню, относится к методу редактировани заявки.
 * {value} DELETE - константа, пункт меню, относится к методу удаления заявки.
 * {value} ALL - константа, пункт меню, относится к методу просмотра всех заявок, которые есть в системе.
 * {value} BY_NAME - константа, пункт меню, относится к методу поиска заявки по названию.
 * {value} BY_ID - константа, пункт меню, относится к методу поиска заявки идентификатору(id).
 * {value} EXIT - константа, пункт меню, относится к процессу выхода из приложения.
 * {value} input - константа, экземпляр класса ConsoleInput. Отвечает за пользовательский ввод.
 * {value} tracker - константа, экземпляр класса Tracker. Отвечает за запуск методов из класса Tracker.
 */
public class StartUI {
    static final String ADD = "1";
    static final String REPLACE = "2";
    static final String DELETE = "3";
    static final String ALL = "4";
    static final String BY_NAME = "5";
    static final String BY_ID = "6";
    static final String EXIT = "0";
    private final ConsoleInput input;
    private final Tracker tracker;

    /**
     * Консруктор класса
     *
     * @param input   - параметром передаем экземпляр класса пользовательского ввода.
     * @param tracker - параметром передаем экземпляр класса логики программы.
     */
    public StartUI(ConsoleInput input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основной цикл программы.
     * Запускаем метод показа меню и сравниваем пользовательский ввод со значением констант.
     * Если с одним из значений совпало, то запускается метод за который отвечает константа.
     * Цикл работает до тех пор, пока {value} exit не станет равно true, это произойдет после того
     * как пользователь выберет выход из программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions();
        for (int i = 0; i < menu.getActionsLength(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(input.ask("Выберите пункт меню:", range));
        } while (!"y".equals(this.input.ask("Уходите?(y): ")));
    }

    /**
     * ================= Реализация пунктов меню. =================
     * <p>
     * Метод запускает создание добавление новой заявки.
     * Мы получаем нужные нам данные от пользователя, создаем экземпляр класса Item
     * и затем добавляем его в наш Tracker.
     */
//    private void createItem() {
//        System.out.println("------------ Добавление новой заявки --------------");
//        String name = this.input.ask("Введите название заявки :");
//        String desc = this.input.ask("Введите описание заявки :");
//        Item item = new Item(name, desc);
//        this.tracker.add(item);
//        System.out.println("------------ Новая заявка с Id : " + item.getId() + " добавлена -----------");
//        System.out.println();
//    }

    /**
     * Метод запускает редактирование заявки.
     * Мы получаем нужные нам данные от пользователя, создаем экземпляр класса Item
     * и затем заменяем им уже имеющуюся заявку.
     */
//    private void replaceItem() {
//        System.out.println("------------ Редактирование заявки --------------");
//        String id = this.input.ask("Введите идентификатор заявки(id) :");
//        String name = this.input.ask("Введите название заявки :");
//        String desc = this.input.ask("Введите описание заявки :");
//        Item item = new Item(name, desc);
//        if (!tracker.replace(id, item)) {
//            System.out.println("Заявка с Id " + id + " не отредактированна.");
//        } else {
//            System.out.println("------------ Заявка с Id " + id + " отредактированна -----------");
//        }
//        System.out.println();
//    }

    /**
     * Метод запускает удаление заявки.
     * Мы получаем нужные нам данные от пользователя,
     * находим заявку и удаляем её из Tracker'a.
     */
//    private void deleteItem() {
//        System.out.println("------------ Удаление заявки --------------");
//        String id = this.input.ask("Введите идентификатор заявки :");
//        String answer = this.input.answer("Вы точно хотите удалить заявку с id " + id + " ?");
//        if (answer.equals("Y") || answer.equals("y") || answer.equals("у") || answer.equals("У")) {
//            tracker.delete(id);
//            System.out.println("------------ Заявка с id " + id + " удалена -----------");
//        } else {
//            System.out.println("------------ Заявка с id " + id + " не удалена -----------");
//        }
//        System.out.println();
//    }

    /**
     * Метод отвечает за показ всех заявок, котрые имеются в базе Tracker'a.
     * Показываются заявки по единому образцу.
     */
//    private void getAllItems() {
//        System.out.println("------------ Все имеющиеся заявки --------------");
//        Item[] items = tracker.getAll();
//        for (Item item : items) {
//            System.out.println(item.toString());
//        }
//        System.out.println();
//    }

    /**
     * Метод отвечает за нахождение заявки по названию.
     * Получаем от пользователя необходимые данные, находим по ним все заявки
     * и выводим их в консоль по единому образцу.
     */
//    private void searchByName() {
//        System.out.println("------------ Поиск заявки по названию --------------");
//        String name = this.input.ask("Введите название заявки :");
//        System.out.println("Вот что удалось найти по названию " + name + ":");
//        Item[] items = tracker.findByName(name);
//        for (Item item : items) {
//            System.out.println(item.toString());
//        }
//        System.out.println();
//    }

    /**
     * Метод отвечает за нахождение заявки по названию.
     * Получаем от пользователя необходимые данные, находим по ним заявку
     * и выводим ее в консоль по образцу.
     */
//    private void searchById() {
//        System.out.println("------------ Поиск заявки по идентификатору(id) --------------");
//        String id = this.input.ask("Введите идентификатор(id) заявки :");
//        Item searchResult = this.tracker.findById(id);
//        if (searchResult == null) {
//            System.out.println("------------ Заявка с Id " + id + " не найдена -----------");
//        } else {
//            System.out.println(searchResult.toString());
//        }
//        System.out.println();
//    }

    /**
     * ================= Метод для запуска программы. =================
     *
     * @param args - указания, которые можно добавить при запуске.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
