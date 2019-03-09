package ru.job4j.chess.src.main.java.ru.job4j.chess.exceptions;

public class ImpossibleMoveException extends RuntimeException {
    public ImpossibleMoveException(String message) {
        super(message);
    }
}
