package ru.job4j.converter;

/**
 * Конвертер валют.
 */
public class Converter {

    /**
     * Метод в котором рубли меняем на евро.
     * @param value - рубли.
     * @return - евро.
     */
    public int rubToEur(int value) {
        return value / 70;
    }

    /**
     * Метод в котором рубли меняем на доллары.
     * @param value - рубли.
     * @return - доллары.
     */
    public int rubToUsd(int value) {
        return value / 60;
    }

    /**
     * Метод в котором евро меняем на рубли.
     * @param value - евро.
     * @return - рубли.
     */
    public int eurToRub(int value) {
        return value * 70;
    }

    /**
     * Метод в котором доллары меняем на рубли.
     * @param value - доллары.
     * @return - рубли.
     */
    public int usdToRub(int value) {
        return value * 60;
    }

    /**
     * Метод в котором доллары меняем на евро.
     * @param value - доллары.
     * @return - евро.
     */
    public double usdToEur(int value) {
        return value * 0.6;
    }
}
