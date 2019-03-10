package ru.job4j.strategy;

public class Paint {
    /**
     * Метод, который принимает на вход объект,
     * реализующий интерфейс Shape.
     * После чего данный метод выводит в консоль метод draw данного объекта.
     *
     * @param shape -объект, который реализует интерфейс Shape.
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.draw(new Square());
        paint.draw(new Triangle());
    }
}
