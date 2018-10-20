package tracker;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();
    List<Integer> range = new ArrayList<>();

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLength() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new ExitProgram(0, "Выход"));
        this.actions.add(new AddItem(1, "Добавление заявки"));
        this.actions.add(new MenuTracker.EditItem(2, "Редактирование заявки"));
        this.actions.add(new MenuTracker.DeleteItem(3, "Удаление заявки"));
        this.actions.add(new ShowItems(4, "Получение списка всех заявок"));
        this.actions.add(new FindItemsByName(5, "Нахождение заявки по названию"));
        this.actions.add(new FindItemById(6, "Нахождение заявки по идентификатору(id)"));
        for (int i = 0; i < actions.size(); i++) {
            range.add(i);
        }
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * ================= Реализация пунктов меню. =================
     * <p>
     * Выход из программы.
     */
    public class ExitProgram implements UserAction {
        private int numberOfMenu;
        private String name;

        public ExitProgram(int numberOfMenu, String name) {
            this.numberOfMenu = numberOfMenu;
            this.name = name;
        }

        @Override
        public int key() {
            return this.numberOfMenu;
        }

        public String reallyExit() {
            return input.ask("Вы нас покидаете?");
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println(reallyExit());
        }

        @Override
        public String info() {
            String ln = System.lineSeparator();
            StringBuilder sb = new StringBuilder();
            sb.append("Меню:").append(ln)
                    .append(numberOfMenu).append(". ")
                    .append(name);
            return sb.toString();
        }
    }

    /**
     * Добавление заявки.
     * <p>
     * Метод запускает создание добавление новой заявки.
     * Мы получаем нужные нам данные от пользователя, создаем экземпляр класса Item
     * и затем добавляем его в наш Tracker.
     */
    public class AddItem implements UserAction {
        private int numberOfMenu;
        private String name;

        public AddItem(int numberOfMenu, String name) {
            this.numberOfMenu = numberOfMenu;
            this.name = name;
        }

        @Override
        public int key() {
            return this.numberOfMenu;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите название заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с Id : " + item.getId() + " добавлена -----------");
            System.out.println();
        }

        /**
         * Отображение меню.
         */
        @Override
        public String info() {
            StringBuilder sb = new StringBuilder();
            sb.append(numberOfMenu).append(". ")
                    .append(name);
            return sb.toString();
        }
    }

    /**
     * Редактирование заявки
     * <p>
     * Метод запускает редактирование заявки.
     * Мы получаем нужные нам данные от пользователя, создаем экземпляр класса Item
     * и затем заменяем им уже имеющуюся заявку.
     */
    private static class EditItem implements UserAction {
        private int numberOfMenu;
        private String name;

        public EditItem(int numberOfMenu, String name) {
            this.numberOfMenu = numberOfMenu;
            this.name = name;
        }

        @Override
        public int key() {
            return this.numberOfMenu;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Редактирование заявки --------------");
            String id = input.ask("Введите идентификатор заявки(id) :");
            String name = input.ask("Введите название заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            if (!tracker.replace(id, item)) {
                System.out.println("Заявка с Id " + id + " не отредактированна.");
            } else {
                System.out.println("------------ Заявка с Id " + id + " отредактированна -----------");
            }
            System.out.println();
        }

        @Override
        public String info() {
            StringBuilder sb = new StringBuilder();
            sb.append(numberOfMenu).append(". ")
                    .append(name);
            return sb.toString();
        }
    }

    /**
     * Показать все заявки.
     * <p>
     * Метод отвечает за показ всех заявок, котрые имеются в базе Tracker'a.
     * Показываются заявки по единому образцу.
     */
    private class ShowItems implements UserAction {
        private int numberOfMenu;
        private String name;

        public ShowItems(int numberOfMenu, String name) {
            this.numberOfMenu = numberOfMenu;
            this.name = name;
        }

        @Override
        public int key() {
            return this.numberOfMenu;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Все имеющиеся заявки --------------");
            Item[] items = tracker.getAll();
            for (Item item : items) {
                System.out.println(item.toString());
            }
            System.out.println();
        }

        @Override
        public String info() {
            StringBuilder sb = new StringBuilder();
            sb.append(numberOfMenu).append(". ")
                    .append(name);
            return sb.toString();
        }
    }

    /**
     * Метод запускает удаление заявки.
     * Мы получаем нужные нам данные от пользователя,
     * находим заявку и удаляем её из Tracker'a.
     */
    private static class DeleteItem implements UserAction {
        private int numberOfMenu;
        private String name;

        public DeleteItem(int numberOfMenu, String name) {
            this.numberOfMenu = numberOfMenu;
            this.name = name;
        }

        @Override
        public int key() {
            return this.numberOfMenu;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите идентификатор заявки :");
            tracker.delete(id);
            System.out.println("------------ Заявка с id " + id + " не удалена -----------");
            System.out.println();
        }

        @Override
        public String info() {
            StringBuilder sb = new StringBuilder();
            sb.append(numberOfMenu).append(". ")
                    .append(name);
            return sb.toString();
        }
    }

    /**
     * Метод отвечает за нахождение заявки по названию.
     * Получаем от пользователя необходимые данные, находим по ним все заявки
     * и выводим их в консоль по единому образцу.
     */
    private class FindItemsByName implements UserAction {
        private int numberOfMenu;
        private String name;

        public FindItemsByName(int numberOfMenu, String name) {
            this.numberOfMenu = numberOfMenu;
            this.name = name;
        }

        @Override
        public int key() {
            return this.numberOfMenu;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по названию --------------");
            String name = input.ask("Введите название заявки :");
            System.out.println("Вот что удалось найти по названию " + name + ":");
            Item[] items = tracker.findByName(name);
            for (Item item : items) {
                System.out.println(item.toString());
            }
            System.out.println();
        }

        @Override
        public String info() {
            StringBuilder sb = new StringBuilder();
            sb.append(numberOfMenu).append(". ")
                    .append(name);
            return sb.toString();
        }
    }
}

/**
 * Метод отвечает за нахождение заявки по названию.
 * Получаем от пользователя необходимые данные, находим по ним заявку
 * и выводим ее в консоль по образцу.
 */
class FindItemById implements UserAction {
    private int numberOfMenu;
    private String name;

    public FindItemById(int numberOfMenu, String name) {
        this.numberOfMenu = numberOfMenu;
        this.name = name;
    }

    @Override
    public int key() {
        return this.numberOfMenu;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Поиск заявки по идентификатору(id) --------------");
        String id = input.ask("Введите идентификатор(id) заявки :");
        Item searchResult = tracker.findById(id);
        if (searchResult == null) {
            System.out.println("------------ Заявка с Id " + id + " не найдена -----------");
        } else {
            System.out.println(searchResult.toString());
        }
        System.out.println();
    }

    @Override
    public String info() {
        StringBuilder sb = new StringBuilder();
        sb.append(numberOfMenu).append(". ")
                .append(name);
        return sb.toString();
    }
}

