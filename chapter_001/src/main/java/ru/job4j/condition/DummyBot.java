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
        String botAnswer = "Это ставит меня в тупик. Спросите другой вопрос.";
        if ("Привет, Бот!".equals(text)) {
            botAnswer = "Привет, умник!";
        } else if ("Пока.".equals(text)) {
            botAnswer = "До скорой встречи";
        }
        return botAnswer;
    }
}