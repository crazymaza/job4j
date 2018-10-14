package strategy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Получаем ссылку на стандартный вывод в консоль.
 * Создаем буфер для хранения вывода.
 * Заменяем стандартный вывод на вывод в пямять для тестирования.
 * Выполняем действия пишушиее в консоль.
 * Проверяем результат вычисления
 * Возвращаем обратно стандартный вывод в консоль.
 */
public class PaintTest {
    private PrintStream stdout = System.out;
    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    /**
     * Данный код выполняется перед запуском тестов.
     */
    @Before
    public void loadOutput() {
        System.out.println("Before tests");
        System.setOut(new PrintStream(this.out));
    }

    /**
     * Данный код выполняется после запуска тестов.
     */
    @After
    public void loadInput() {
        System.setOut(this.stdout);
        System.out.println("After tests");
    }

    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("*****").append("\n")
                                .append("*****").append("\n")
                                .append("*****")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }


}
