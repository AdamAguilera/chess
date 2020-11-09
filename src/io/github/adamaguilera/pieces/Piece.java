package io.github.adamaguilera.pieces;
import io.github.adamaguilera.board.Position;

public interface Piece {
    String ANSI_RESET = "\u001B[0m";
    String ANSI_WHITE = "\u001B[37m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_BLUE = "\u001B[34m";

    // System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);
    static String format (boolean isWhite, String symbol) {
        return isWhite ? ANSI_BLUE + symbol + ANSI_RESET :
                ANSI_RED + symbol + ANSI_RESET;
    }

    Position getPosition ();
    boolean canMove(Position position);
    boolean move (Position position);
    @Override
    String toString ();
    @Override
    int hashCode ();
}
