package ru.job4j.loop;

/**
 * Класс, который рисует шахматную доску по размерам.
 */
public class Board {
    /**
     * Метод рисования шахматной доски.
     * @param width - ширина доски.
     * @param height - высота доски.
     * @return - возвращает информацию из буфера StringBuilder'a.
     * {@value} builder - Запоминает вводимые символы в буфер.
     * {@value} ln - Автоматически определяет переход на новую строку в зависимости от ОС.
     * builder.append("X"); - Добавляет Х в строку.
     * builder.append(" "); - Добавляет пробел в строку.
     * builder.append(ln); - Делаем перенос строки.
     */
    public String paint(int width, int height) {
        StringBuilder builder = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    builder.append("X");
                } else {
                    builder.append(" ");
                }
            }
            builder.append(ln);
        }
        return builder.toString();
    }
}
