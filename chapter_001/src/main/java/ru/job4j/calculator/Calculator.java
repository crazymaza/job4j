package ru.job4j.calculator;

/**
 * Класс калькулятора,
 * который умеет выполнять простейшие
 * математические действия
 */
public class Calculator {
    /**
     * Приватный параметр, который
     * будет выводить результат вычисления
     */
    private double result;

    /**
     * Метод сложения
     * @param first - что складываем
     * @param second - с чем складываем
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Метод вычитания
     * @param first - из чего вычитаем
     * @param second - что вычитаем
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Метод деления
     * @param first - что делим
     * @param second - на что делим
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Метод умножения
     * @param first - что умножаем
     * @param second - на что умножаем
     */
    void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Метод, который возвражает результат действия
     * @return - возвращаем результат действия
     */
    public double getResult() {
        return this.result;
    }
}
