package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DummyBotTest {
    private DummyBot bot = new DummyBot();

    @Test
    public void whenSayHello() {
        String result = bot.answer("Привет, Бот!");
        String expected = "Привет, умник!";
        assertThat(result, is(expected));
    }

    @Test
    public void whenSayBye() {
        String result = bot.answer("Пока.");
        String expected = "До скорой встречи";
        assertThat(result, is(expected));
    }

    @Test
    public void whenSayAnything() {
        String result = bot.answer("Каракум.");
        String expected = "Это ставит меня в тупик. Спросите другой вопрос.";
        assertThat(result, is(expected));
    }


}
