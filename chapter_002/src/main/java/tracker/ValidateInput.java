package tracker;

import java.util.List;

public class ValidateInput extends ConsoleInput {

    @Override
    public String ask(String question) {
        return super.ask(question);
    }

    @Override
    public int ask(String question, List<Integer> range) {
        int value = -1;
        boolean valid = true;
        do {
            try {
                value = super.ask(question, range);
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
