package tracker;

import java.util.Scanner;

public class ConsoleInput {

    public String ask(String question) {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public Character answer(String question) {
        System.out.println(question);
        System.out.println("Если да, то нажмите Y, если нет, то любую клавишу.");
        Scanner scanner = new Scanner(System.in);
        return scanner.next().charAt(0);
    }

}
