package io.github.adamaguilera.pieces;

import io.github.adamaguilera.board.Position;

public class Queen implements Piece {
    static final String SYMBOL = "Q";
    boolean isWhite;

    public Queen(boolean isWhite) {
        this.isWhite = isWhite;
    }

    @Override
    public Position getPosition() {
        return null;
    }

    @Override
    public boolean canMove(Position position) {
        return false;
    }

    @Override
    public boolean move(Position position) {
        return false;
    }

    @Override
    public String toString () {
        return Piece.format(isWhite, SYMBOL);
    }

    @Override
    public int hashCode () {
        return SYMBOL.hashCode();
    }
}
