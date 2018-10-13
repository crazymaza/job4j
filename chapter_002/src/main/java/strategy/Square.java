package strategy;

public class Square implements Shape {
    /**
     * Переопределяем метод из интерфейса Shape.
     * Метод возввращает фигуру из символов *
     *
     * @return готовая фигура из символов.
     */
    @Override
    public String draw() {
        StringBuilder sb = new StringBuilder();
        sb.append("*****").append("\n")
                .append("*****").append("\n")
                .append("*****");
        return sb.toString();
    }
}
