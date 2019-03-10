package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.src.main.java.ru.job4j.chess.Logic;
import ru.job4j.chess.src.main.java.ru.job4j.chess.exceptions.FigureNotFoundException;
import ru.job4j.chess.src.main.java.ru.job4j.chess.exceptions.OccupiedWayException;
import ru.job4j.chess.src.main.java.ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static ru.job4j.chess.src.main.java.ru.job4j.chess.firuges.Cell.*;

public class LogicTest {
    Logic logic = new Logic();

    @Test(expected = OccupiedWayException.class)
    public void whenMoveIsOccupied() {
        logic.add(new BishopBlack(B2));
        logic.add(new BishopBlack(C1));
        logic.move(C1, B2);
    }

    @Test(expected = FigureNotFoundException.class)
    public void whenFigureNotFound() {
        logic.add(new BishopBlack(C1));
        logic.move(C2, C3);
    }

    @Test
    public void whenStepIsPossible() {
        logic.add(new BishopBlack(F8));
        boolean result = logic.move(F8, E7);
        assertThat(result, is(true));
    }
}
