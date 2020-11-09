package io.github.adamaguilera.pieces;

import io.github.adamaguilera.board.Position;

public class Knight implements Piece {
    static final String SYMBOL = "N";
    boolean isWhite;

    public Knight(boolean isWhite) {
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
