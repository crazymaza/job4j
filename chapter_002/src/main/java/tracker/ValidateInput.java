package tracker;

import java.util.List;
import java.util.Scanner;

public class ValidateInput implements Input {
    Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public int ask(String question, List<Integer> range) {
        int value = -1;
        boolean invalid = true;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException e) {
                System.out.println("Нет такого пункта, выберите другой.");
            } catch (NumberFormatException e) {
                System.out.println("Нужно вводить только цифры. Повторите ввод.");
            }
        } while (invalid);
        return value;
    }
}
