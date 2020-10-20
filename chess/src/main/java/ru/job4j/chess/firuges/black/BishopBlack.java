package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(this.position(), dest)) {
            throw new IllegalStateException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs( this.position().getX() - dest.getX() );
        int deltaX = position().getX() < dest.getX() ? 1 : -1;
        int deltaY = position().getY() < dest.getY() ? 1 : -1;
        Cell[] rsl = new Cell[size];
        for (int i = 0; i < size; i++) {
            rsl[i] = Cell.findBy(position.getX() + deltaX * (i + 1),
                    position.getY() + deltaY * (i + 1));
        }
    return rsl;
    }

    public static boolean isDiagonal(Cell source, Cell dest) {
        int deltaX = source.getX() < dest.getX() ? 1 : -1;
        int deltaY = source.getY() < dest.getY() ? 1 : -1;
        boolean rsl = false;

        while (Cell.findBy(source.getX() + deltaX,
                source.getY() + deltaY) != null) {
            source = Cell.findBy(source.getX() + deltaX,
                    source.getY() + deltaY);
            if (source.equals(dest)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }


    public static void main(String[] args) {
        boolean rsl = BishopBlack.isDiagonal(Cell.C1, Cell.C2);
        System.out.println(rsl);
    }

}
