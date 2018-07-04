package ru.job4j.fit;

/**
 * Вычисление идеального веса.
 */
public class Fit {

    /**
     * Идевльный вес для мужчины.
     * @param value - рост.
     * @return - вес.
     */
    public double manWeight(int value) {
        return (value - 100) * 1.15;
    }

    /**
     * Идеальный вес для женщины.
     * @param value - рост.
     * @return - вес.
     */
    public double womanWeight(int value) {
        return (value - 110) * 1.15;
    }
}
