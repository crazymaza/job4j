package strategy;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(triangle.draw(),
                is(
                        new StringBuilder()
                                .append("  *  ").append("\n")
                                .append(" *** ").append("\n")
                                .append("*****")
                                .toString()
                )
        );
    }
}
