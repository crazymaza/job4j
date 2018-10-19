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
     * ================= Метод для запуска программы. =================
     *
     * @param args - указания, которые можно добавить при запуске.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
