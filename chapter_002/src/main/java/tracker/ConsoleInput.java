package tracker;

import java.util.List;
import java.util.Scanner;

/**
 * Класс пользовательского для считывания значений,
 * которые пользователь ввел в консоль.
 */
public class ConsoleInput implements Input {

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
        int key =  Integer.valueOf(scanner.nextLine());
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Не верный пункт меню");
        }
        return key;
    }
}
