package ru.job4j.chess.src.main.java.ru.job4j.chess.firuges.black;

import javafx.scene.control.Alert;
import ru.job4j.chess.src.main.java.ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.src.main.java.ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.src.main.java.ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack extends Figure {

    public BishopBlack(final Cell position) {
        super(position);

    }

    @Override
    public Cell position() {
        return super.position();
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
            Cell[] move = new Cell[Math.abs(source.x - dest.x)];
            try {
                do {
                    move = moveDiagonal(source, dest);
                } while (isDiagonal(source, dest));
            } catch (ImpossibleMoveException ime) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ходим только по диагонали!");
                alert.setHeaderText(null);
                alert.setContentText("Слон ходит только по диагонали!");
                alert.showAndWait();
            }
        return move;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

}
