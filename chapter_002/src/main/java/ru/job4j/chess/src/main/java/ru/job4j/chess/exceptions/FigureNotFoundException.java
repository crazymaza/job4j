package ru.job4j.chess.src.main.java.ru.job4j.chess.exceptions;

public class FigureNotFoundException extends RuntimeException {
    public FigureNotFoundException(String message) {
        super(message);
    }
}
