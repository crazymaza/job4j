package ru.job4j.condition;

import ru.job4j.point.Point;

/**
 * Create triangle class.
 */
public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    /**
     * Create triangle constructor.
     * @param a - The first vertex of the triangle.
     * @param b - The second vertex of the triangle.
     * @param c - The third vertex of the triangle.
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * The method computes a semiperimeter.
     * @param ab - Расстояние от а до b.
     * @param ac - Расстояние от а до c.
     * @param bc - Расстояние от b до с.
     * @return - возврат значения полупериметра.
     */
    private double point(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }

    /**
     * Метод для вычисления возможности построения треугольника.
     * @param ab - Расстояние от а до b.
     * @param ac - Расстояние от а до c.
     * @param bc - Расстояние от b до с.
     * @return - возвращает true если можно построить треугольник.
     */
    private boolean exist(double ab, double ac, double bc) {
        return (((ab + bc) > ac) && ((ab + ac) > bc) && ((ac + bc) > ab));
    }

    /**
     * Метод для вычисления площади треугольника.
     * @return - возвращает значение площади треугольника.
     */
    public double area() {
        double result = -1;
        double ab = a.distanceTo(b);
        double ac = a.distanceTo(c);
        double bc = b.distanceTo(c);
        double p = this.point(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            result = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return result;
    }
}
