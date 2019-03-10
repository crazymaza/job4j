package ru.job4j.strategy;

/**
 * Интерфейс, который определяет метод для рисования фигуры.
 * Интерфейс наследуется классами Triangle и Square.
 * В данном пакете применён шаблон "Стратегия".
 */
public interface Shape {
    String draw();
}
