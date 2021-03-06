package ru.job4j.tracker;

import java.util.List;

public class ValidateInput implements Input {
    private Input input;

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
