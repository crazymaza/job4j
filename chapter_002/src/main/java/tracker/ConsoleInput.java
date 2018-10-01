package tracker;

import java.util.Scanner;

public class ConsoleInput {

    public String ask(String question) {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
