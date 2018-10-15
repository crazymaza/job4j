package strategy;

public class Triangle implements Shape {
    /**
     * Переопределяем метод из интерфейса Shape.
     * Метод возввращает фигуру из символов *
     *
     * @return готовая фигура из символов.
     */
    @Override
    public String draw() {
        String ln = System.lineSeparator();
        StringBuilder sb = new StringBuilder();
        sb.append("  *  ").append(ln)
                .append(" *** ").append(ln)
                .append("*****");
        return sb.toString();
    }
}
