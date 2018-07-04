package ru.job4j;

/**
 * В классе вычисляется расстояние между
 * двумя точками в системе координат.
 */
public class Point {
    private int x;
    private int y;

    /**
     * Конструктор класса.
     * @param x - первая координата.
     * @param y - вторая координата.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Вычисление расстояния между двумя точками
     * в системе координат.
     * @param that - параметр в который передается вторая точка.
     * @return - расстояние между точками.
     */
    public double distanceTo(Point that) {
        return Math.sqrt(Math.pow(this.x - that.x, 2) + (Math.pow(this.y - that.y, 2)));
    }
}
