package ru.job4j.chess.src.main.java.ru.job4j.chess;

import ru.job4j.chess.src.main.java.ru.job4j.chess.exceptions.FigureNotFoundException;
import ru.job4j.chess.src.main.java.ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.src.main.java.ru.job4j.chess.exceptions.OccupiedWayException;
import ru.job4j.chess.src.main.java.ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.src.main.java.ru.job4j.chess.firuges.Figure;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    /**
     * Проходимся в цикле по массиву ячеек и по массиву фигур.
     * Если значения ячейки куда будет сделан ход совпадает с одним из значений
     * массива фигур, то выбрасываем исключение о занятости ячейки.
     * В ином случае делается ход.
     *
     * @param source - откуда делается ход.
     * @param dest   - куда делается ход.
     * @return - возвращаем булево значение возможно сделать ход или нет.
     * @throws ImpossibleMoveException - ошибка, если невозможно пойти.
     * @throws OccupiedWayException    - ошибка, если клетка занята.
     * @throws FigureNotFoundException - ошибка, если фигура не найдена.
     */
    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException,
            OccupiedWayException, FigureNotFoundException {
        boolean rst = false;
        int index = this.findBy(source);
        if (index != -1) {
            Cell[] steps = this.figures[index].way(source, dest);
                for (Cell step1 : steps) {
                    for (Figure figure : figures) {
                        if ((step1.y) == (figure.position().y) &&
                                (step1.x) == (figure.position().x)) {
                            throw new OccupiedWayException("This place is already taken");
                        }
                    }
                }


            if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
                rst = true;
                this.figures[index] = this.figures[index].copy(dest);
            }
        }
        return rst;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
