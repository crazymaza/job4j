package ru.job4j.array;

public class ArrayChar {
    private char[] data;

    /**
     * Обертка(конструктор) класса.
     *
     * @param line - слово, которое будет разбито посимвольно.
     *             toCharArray() - делает из слова массив char'ов
     */
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Метод, который сравнивает начальные буквы
     *
     * @param prefix - буквы с которых начинается слово
     * @return - верно ли заданы начальные символы.
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int i = 0; i < value.length; i++) {
            if (data[i] != value[i]) {
                result = false;
            }
        }
        return result;
    }
}
