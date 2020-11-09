package io.github.adamaguilera.board;

import io.github.adamaguilera.pieces.*;

public class Board {
    static final String PRINT_LINE = "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";
    static final String INDENT = "      ";
    static final String SPACING = "  ";
    static final String EMPTY_SQUARE = "☐";
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_RESET = "\u001B[0m";

    static final int MAX_ROW = 8;
    static final int MAX_COL = 8;

    Piece[][] board;

    int turn;
    boolean whiteToMove;

    public Board () {
        board = new Piece[MAX_ROW][MAX_COL];
        // set up board
        initBoard();
        whiteToMove = true;
        turn = 1;
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(PRINT_LINE);
        res.append(getBoardInfo());
        for (int col = 0; col < MAX_COL; col ++) {
            if (col == 0) {
                res.append(getLetters());
            }
            res.append(INDENT);
            res.append(ANSI_GREEN + (MAX_ROW - col) + ANSI_RESET + SPACING);
            for (int row = 0; row < MAX_ROW; row ++) {
                Piece curr = board[row][col];
                String symbol = curr == null ? EMPTY_SQUARE : curr.toString();
                res.append(symbol).append(SPACING);
            }
            res.append(ANSI_GREEN + (MAX_ROW - col) + ANSI_RESET + SPACING);
            res.append("\n");
        }
        res.append(getLetters());
        res.append(PRINT_LINE);
        return res.toString();
    }
    private String getBoardInfo () {
        StringBuilder res = new StringBuilder();
        res.append("Turn: " + turn + " | ");
        res.append("Move: " + (whiteToMove ? "White" : "Black") + " | ");
        res.append("Board state: " + hashCode());
        res.append("\n");
        return res.toString();
    }
    private String getLetters () {
        StringBuilder res = new StringBuilder();
        res.append(INDENT + " " + SPACING);
        for (int let = 'A'; let <= 'H'; let++) {
            char curr = (char) let;
            res.append(ANSI_GREEN).append(curr).append(ANSI_RESET).append(SPACING);
        }
        res.append("\n");
        return res.toString();
    }

    @Override
    public int hashCode() {
        if (board == null) return -1;
        int hash = 7;
        for (int row = 0; row < MAX_ROW; row ++) {
            for (int col = 0; col < MAX_COL; col ++) {
                hash = 31 * hash + (board[row][col] == null ? 0 : board[row][col].hashCode());
            }
        }
        return hash;
    }
    public String getFen() {
        StringBuilder res = new StringBuilder("");
        return null;
    }

    private void initBoard () {
        initBoard(true);
        initBoard(false);
    }

    private void initBoard (boolean isWhite) {
        int offset = isWhite ? MAX_COL - 1: 0;
        int pawn = isWhite ? MAX_COL - 2 : 1;
        int c;
        int r;
        // set back rank
        // set rooks
        c = offset;
        r = 0;
        // set rooks
        board[r++][c] = new Rook(isWhite);
        board[MAX_ROW - r][c] = new Rook(isWhite);
        // set knights
        board[r++][c] = new Knight(isWhite);
        board[MAX_ROW - r][c] = new Knight(isWhite);
        // set bishops
        board[r++][c] = new Bishop(isWhite);
        board[MAX_ROW - r][c] = new Bishop(isWhite);
        // set queen
        board[r++][c] = new Queen(isWhite);
        board[r][c] = new King(isWhite);
        // set pawns
        for (int row = 0; row < MAX_ROW; row ++) {
            board[row][pawn] = new Pawn(isWhite);
        }
    }

    public Piece[][] getBoard() { return board; }
    public boolean isWhiteToMove () { return whiteToMove; }
    public int getTurn () { return getTurn(); }
}
