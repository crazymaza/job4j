package ru.job4j.condition;

/**
 * Класс в котором бот знает только 3 фразы.
 */
public class DummyBot {

    /**
     * Метод в котором боту "говорят" 3 фразы.
     * @param text - фраза, котороую говорят боту.
     * @return - фраза, которую бот говорит в ответ.
     */
    public String answer(String text) {
        String answer = "Это ставит меня в тупик. Спросите другой вопрос.";
        if ("Привет, Бот!".equals(text)) {
            answer = "Привет, умник!";
        } else if ("Пока.".equals(text)) {
            answer = "До скорой встречи";
        }
        return answer;
    }
}