package tracker;

/**
 * Класс в котором мы запускаем программу и
 * в котором происходит вызов всех методов программы.
 * <p>
 * {value} input - константа, экземпляр класса ConsoleInput. Отвечает за пользовательский ввод.
 * {value} tracker - константа, экземпляр класса Tracker. Отвечает за запуск методов из класса Tracker.
 * {value} exit - отвечает за выход из программы.
 */
public class StartUI {
    private final Input input;
    private final Tracker tracker;
    private boolean exit;

    /**
     * Консруктор класса
     *
     * @param input   - параметром передаем экземпляр класса пользовательского ввода.
     * @param tracker - параметром передаем экземпляр класса логики программы.
     */
    public StartUI(Input input, Tracker tracker) {
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
        menu.fillActions(this);
        do {
            menu.show();
            menu.select(input.ask("Выберите пункт меню:", menu.range));
        } while (!this.exit);
    }

    public void exitFromTheProgram() {
        this.exit = true;
    }

    /**
     * ================= Метод для запуска программы. =================
     *
     * @param args - указания, которые можно добавить при запуске.
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput (new ConsoleInput()), new Tracker()).init();
    }
}
