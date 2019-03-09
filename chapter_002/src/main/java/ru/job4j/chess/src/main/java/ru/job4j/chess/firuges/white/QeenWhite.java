package ru.job4j.chess.src.main.java.ru.job4j.chess.firuges.white;

import ru.job4j.chess.src.main.java.ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.src.main.java.ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class QeenWhite extends Figure {

    public QeenWhite(final Cell position) {
        super(position);
    }

    @Override
    public Cell position() {
        return super.position();
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        return new Cell[]{dest};
    }

    @Override
    public Figure copy(Cell dest) {
        return new QeenWhite(dest);
    }
}
