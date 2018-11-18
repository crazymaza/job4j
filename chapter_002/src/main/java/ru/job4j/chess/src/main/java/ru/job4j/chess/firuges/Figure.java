package ru.job4j.chess.src.main.java.ru.job4j.chess.firuges;

import ru.job4j.chess.src.main.java.ru.job4j.chess.exceptions.ImpossibleMoveException;

public abstract class Figure {
    private final Cell position;

    public Figure(Cell position) {
        this.position = position;
    }

    public Cell position() {
        return this.position;
    }

    public abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    public String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );

    }

    public abstract Figure copy(Cell dest);

    public Cell[] moveDiagonal(Cell source, Cell dest) throws ImpossibleMoveException {
        if (isDiagonal(source, dest)) {
            throw new ImpossibleMoveException("Not diagonal!");
        }
        int deltaX = Integer.compare(dest.x, source.x);
        int deltaY = Integer.compare(dest.y, source.y);
        int move = Math.abs(source.x - dest.x);
        Cell[] steps = new Cell[move];
        steps[0] = Cell.findCell(source.x + deltaX, source.y + deltaY);
        for (int index = 1; index < steps.length; index++) {
            steps[index] = Cell.findCell(steps[index - 1].x + deltaX, steps[index - 1].y + deltaY);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean valid = false;
        int move = Math.abs(source.x - dest.x);
        if (source.y == dest.y + move && source.x == dest.x + move
                || source.y == dest.y + move && source.x == dest.x - move
                || source.y == dest.y - move && source.x == dest.x + move
                || source.y == dest.y - move && source.x == dest.x - move) {
            valid = true;
        }
        return !valid;
    }
}
