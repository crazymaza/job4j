package tracker;

import java.util.List;

public class ValidateInput implements Input {
    Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    @Override
    public int ask(String question, List<Integer> range) {
        int value = -1;
        boolean valid = true;
        do {
            try {
                value = this.input.ask(question, range);
                valid = false;
            } catch (MenuOutException e) {
                System.out.println("Нет такого пункта, выберите другой.");
            } catch (NumberFormatException e) {
                System.out.println("Нужно вводить только цифры. Повторите ввод.");
            }
        } while (valid);
        return value;
    }
}
