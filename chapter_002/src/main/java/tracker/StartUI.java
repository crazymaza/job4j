package tracker;

public class StartUI {
/*    добавление заявок - public Item add(Item item);
    редактирование заявок - public void replace(String id, Item item);
    удаление заявок - public void delete(String id);
    получение списка всех заявок - public Item[] findAll();
    получение списка по имени - public Item[] findByName(String key);
    получение заявки по id - public Item findById(String id);*/

    private static final String ADD = "1";
    private static final String REPLACE = "2";
    private static final String DELETE = "3";
    private static final String ALL = "4";
    private static final String BY_NAME = "5";
    private static final String BY_ID = "6";
    private static final String EXIT = "0";
    private final ConsoleInput input;
    private final Tracker tracker;

    public StartUI(ConsoleInput input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основной цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                //добавление заявки вынесено в отдельный метод.
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
     * Реализация пунктов меню.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите название заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с Id : " + item.getId() + " -----------");
        System.out.println();
    }

    private void replaceItem() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите идентификатор заявки(id) :");
        String name = this.input.ask("Введите название заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.replace(id, item);
        System.out.println("------------ Заявка с Id : " + item.getId() + " отредактированна -----------");
        System.out.println();
    }

    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите идентификатор заявки :");
        char answer = this.input.answer("Вы точно хотите удалить заявку с id " + id + " ?");
        if (answer == 'Y' || answer == 'y' || answer == 'у' || answer == 'У') {
            this.tracker.delete(id);
            System.out.println("------------ Заявка с id " + id + " удалена. -----------");
        } else {
            System.out.println("------------ Заявка с id " + id + " не удалена. -----------");
        }
        System.out.println();
    }

    private void getAllItems() {
        System.out.println("------------ Все имеющиеся заявки --------------");
        Item[] items = tracker.getAll();
        for (Item item : items) {
            System.out.printf("Id заявки: %s\n", item.getId());
            System.out.printf("Название заявки: %s\n", item.getName());
            System.out.printf("Описание заявки: %s\n", item.getDescription());
            System.out.println("-------------");
        }
        System.out.println();
    }

    private void searchByName() {
        System.out.println("------------ Поиск заявки по названию --------------");
        String name = this.input.ask("Введите название заявки :");
        Item[] items = tracker.findByName(name);
        System.out.printf("Вот что удалось найти по названию %s:\n", name);
        for (Item item : items) {
            System.out.printf("Id заявки: %s\n", item.getId());
            System.out.printf("Название заявки: %s\n", item.getName());
            System.out.printf("Описание заявки: %s\n", item.getDescription());
            System.out.println("-------------");
        }
        System.out.println();
    }

    private void searchById() {
        System.out.println("------------ Поиск заявки по идентификатору(id) --------------");
        String id = this.input.ask("Введите идентификатор(id) заявки :");
        System.out.println("Вот что удалось найти по id: " + this.tracker.findById(id).getId());
        System.out.printf("Id заявки: %s\n", this.tracker.findById(id).getId());
        System.out.printf("Название заявки: %s\n", this.tracker.findById(id).getName());
        System.out.printf("Описание заявки: %s\n", this.tracker.findById(id).getDescription());
        System.out.println();
    }


    /**
     * Метод для запуска программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }


}
