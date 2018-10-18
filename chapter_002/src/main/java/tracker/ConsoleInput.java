package tracker;

import java.util.List;
import java.util.Scanner;

/**
 * Класс пользовательского для считывания значений,
 * которые пользователь ввел в консоль.
 */
public class ConsoleInput {

    /**
     * Метод, который считывает значения, которые пользователь ввел в консоль.
     * В программе применяется при создании экземпляров класса Item.
     *
     * @param question - Вопрос на который пользователь будет вводить ответ в консоль.
     * @return возвращает пользовательский ответ.
     */
    public String ask(String question) {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int ask(String question, List<Integer> range) {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        return Integer.valueOf(scanner.nextLine());
    }

    /**
     * Метод, который считывает значения, которые пользователь ввел в консоль.
     * В программе применяется в методе удаления заявки.
     *
     * @param question - Вопрос на который пользователь будет вводить ответ в консоль.
     * @return возвращает пользовательский ответ.
     */
    public String answer(String question) {
        System.out.println(question);
        System.out.println("Если да, то нажмите Y, если нет, то любую клавишу.");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
