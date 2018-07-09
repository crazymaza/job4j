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
     */
    public String paint(int width, int height) {
        StringBuilder stringBuilder = new StringBuilder(); //Запоминает вводимые символы в буфер.
        String ln = System.lineSeparator(); //Автоматически определяет переход на новую строку в зависимости от ОС.
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    stringBuilder.append("X"); //Добавляет Х в строку.
                } else {
                    stringBuilder.append(" "); //Добавляет пробел в строку.
                }
            }
            stringBuilder.append(ln); //Делаем перенос строки.
        }
        return stringBuilder.toString(); //Выводим всю информацию из буфера. По-умолчанию выводится в одну строку.
    }
}
