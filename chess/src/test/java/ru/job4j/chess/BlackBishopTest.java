package ru.job4j.chess;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.CoreMatchers.is;

public class BlackBishopTest {
    @Test
    public void positionTest() {
        Figure figure = new BishopBlack(Cell.C1);
        Cell rsl = figure.position();
        Cell expect = Cell.C1;
        Assert.assertEquals(rsl, expect);
    }

    @Test
    public void copyTest() {
        Figure figure = new BishopBlack(Cell.C1);
        Cell rsl = figure.copy(Cell.H6).position();
        Cell expect = Cell.H6;
        Assert.assertEquals(rsl, expect);
    }

    @Test
    public void wayTest()
            throws ImpossibleMoveException {
        Figure figure = new BishopBlack(Cell.C1);
        Cell[] expect = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Cell[] rsl = figure.way(Cell.G5);
        Assert.assertThat(rsl, is(expect));
    }

    @Test
    public void way2Test()
            throws ImpossibleMoveException {
        Figure figure = new BishopBlack(Cell.A6);
        Cell[] expect = {Cell.B5, Cell.C4, Cell.D3, Cell.E2};
        Cell[] rsl = figure.way(Cell.E2);
        Assert.assertThat(rsl, is(expect));
    }

    @Test(expected = IllegalStateException.class)
    public void WhenWayExeptionTest()
            throws ImpossibleMoveException {
        Figure figure = new BishopBlack(Cell.A6);
        figure.way(Cell.E1);
    }

    @Test
    public void isDiagonalTest() {
        boolean rsl = BishopBlack.isDiagonal(Cell.C1, Cell.G5);
        Assert.assertThat(rsl, is(true));
    }
}
