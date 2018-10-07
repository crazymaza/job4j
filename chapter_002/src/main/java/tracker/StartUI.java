package tracker;

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
    private static final String ADD = "1";
    private static final String REPLACE = "2";
    private static final String DELETE = "3";
    private static final String ALL = "4";
    private static final String BY_NAME = "5";
    private static final String BY_ID = "6";
    private static final String EXIT = "0";
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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (REPLACE.equals(answer)) {
                this.replaceItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (ALL.equals(answer)) {
                this.getAllItems();
            } else if (BY_NAME.equals(answer)) {
                this.searchByName();
            } else if (BY_ID.equals(answer)) {
                this.searchById();
            } else if (EXIT.equals(answer)) {
                System.out.println("Уже уходите? Ну что ж, до скорой встречи!");
                exit = true;
            }
        }
    }

    /**
     * Отображение меню.
     */
    private void showMenu() {
        System.out.println("Меню:");
        System.out.println("1. Добавление заявки");
        System.out.println("2. Редактирование заявки");
        System.out.println("3. Удаление заявки");
        System.out.println("4. Получение списка всех заявок");
        System.out.println("5. Нахождение заявки по названию");
        System.out.println("6. Нахождение заявки по идентификатору(id)");
        System.out.println("0. Выход");
    }

    /**
     * ================= Реализация пунктов меню. =================
     * <p>
     * Метод запускает создание добавление новой заявки.
     * Мы получаем нужные нам данные от пользователя, создаем экземпляр класса Item
     * и затем добавляем его в наш Tracker.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите название заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с Id : " + item.getId() + " добавлена -----------");
        System.out.println();
    }

    /**
     * Метод запускает редактирование заявки.
     * Мы получаем нужные нам данные от пользователя, создаем экземпляр класса Item
     * и затем заменяем им уже имеющуюся заявку.
     */
    private void replaceItem() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите идентификатор заявки(id) :");
        Item[] items = tracker.getAll();
        if (items.length == 0) {
            System.out.println("------------ Заявка с Id " + id + " не найдена ------------");
        }
        for (Item searchItem : items) {
            if (!searchItem.getId().equals(id)) {
                System.out.println("------------ Заявка с Id " + id + " не найдена ------------");
                break;
            } else {
                String name = this.input.ask("Введите название заявки :");
                String desc = this.input.ask("Введите описание заявки :");
                Item item = new Item(name, desc);
                boolean replaceResult = tracker.replace(id, item);
                if (!replaceResult) {
                    System.out.println("Заявка с Id " + id + " не отредактированна.");
                } else {
                    System.out.println("------------ Заявка с Id " + id + " отредактированна -----------");
                }
            }
        }
        System.out.println();
    }

    /**
     * Метод запускает удаление заявки.
     * Мы получаем нужные нам данные от пользователя,
     * находим заявку и удаляем её из Tracker'a.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите идентификатор заявки :");
        Item[] items = tracker.getAll();
        if (items.length == 0) {
            System.out.println("------------ Заявка с Id " + id + " не найдена ------------");
        }
        for (Item searchItem : items) {
            if (!searchItem.getId().equals(id)) {
                System.out.println("------------ Заявка с Id " + id + " не найдена ------------");
            } else {
                char answer = this.input.answer("Вы точно хотите удалить заявку с id " + id + " ?");
                if (answer == 'Y' || answer == 'y' || answer == 'у' || answer == 'У') {
                    boolean deleteItem = this.tracker.delete(id);
                    if (!deleteItem) {
                        System.out.println("------------ Заявка с id " + id + " не удалена -----------");
                    } else {
                        System.out.println("------------ Заявка с id " + id + " удалена -----------");
                        break;
                    }
                } else {
                    System.out.println("----------- Заявка с id " + id + " не удалена -----------");
                }
            }
        }
        System.out.println();
    }

    /**
     * Метод отвечает за показ всех заявок, котрые имеются в базе Tracker'a.
     * Показываются заявки по единому образцу.
     */
    private void getAllItems() {
        Item[] items = tracker.getAll();
        if (items.length == 0) {
            System.out.println("------------ Еще нет ни одной заявки ------------");
        } else {
            System.out.println("------------ Все имеющиеся заявки --------------");
            for (Item item : items) {
                System.out.printf("Id заявки: %s\n", item.getId());
                System.out.printf("Название заявки: %s\n", item.getName());
                System.out.printf("Описание заявки: %s\n", item.getDescription());
                System.out.println("-------------");
            }
        }
        System.out.println();
    }

    /**
     * Метод отвечает за нахождение заявки по названию.
     * Получаем от пользователя необходимые данные, находим по ним все заявки
     * и выводим их в консоль по единому образцу.
     */
    private void searchByName() {
        System.out.println("------------ Поиск заявки по названию --------------");
        String name = this.input.ask("Введите название заявки :");
        Item[] itemsName = tracker.getAll();
        if (itemsName.length == 0) {
            System.out.println("------------ Заявок с именем " + name + " не найдено ------------");
        }
        Item[] items = tracker.findByName(name);
        if (items.length == 0) {
            System.out.println("------------ Заявок с именем " + name + " не найдено ------------");
        } else {
            System.out.printf("Вот что удалось найти по названию %s:\n", name);
            for (Item item : items) {
                System.out.printf("Id заявки: %s\n", item.getId());
                System.out.printf("Название заявки: %s\n", item.getName());
                System.out.printf("Описание заявки: %s\n", item.getDescription());
                System.out.println("-------------");
            }
        }
        System.out.println();
    }

    /**
     * Метод отвечает за нахождение заявки по названию.
     * Получаем от пользователя необходимые данные, находим по ним заявку
     * и выводим ее в консоль по образцу.
     */
    private void searchById() {
        System.out.println("------------ Поиск заявки по идентификатору(id) --------------");
        String id = this.input.ask("Введите идентификатор(id) заявки :");
        Item[] items = tracker.getAll();
        if (items.length > 0) {
            Item searchResult = this.tracker.findById(id);
            if (searchResult == null) {
                System.out.println("------------ Заявка с Id " + id + " не найдена -----------");
            } else {
                System.out.println("Вот что удалось найти по id: " + searchResult.getId());
                System.out.printf("Id заявки: %s\n", searchResult.getId());
                System.out.printf("Название заявки: %s\n", searchResult.getName());
                System.out.printf("Описание заявки: %s\n", searchResult.getDescription());
                System.out.println();
            }
        } else {
            System.out.println("------------ Заявка с Id " + id + " не найдена ------------");
        }

    }

    /**
     * ================= Метод для запуска программы. =================
     *
     * @param args - указания, которые можно добавить при запуске.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
