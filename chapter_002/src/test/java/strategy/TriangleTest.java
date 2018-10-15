package strategy;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void whenDrawTriangle() {
        String ln = System.lineSeparator();
        Triangle triangle = new Triangle();
        assertThat(triangle.draw(),
                is(
                        new StringBuilder()
                                .append("  *  ").append(ln)
                                .append(" *** ").append(ln)
                                .append("*****")
                                .toString()
                )
        );
    }
}
