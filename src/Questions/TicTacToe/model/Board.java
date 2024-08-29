package Questions.TicTacToe.model;

public class Board {
    private final PieceType[][] board;
    private final int size;

    public Board(int size) {
        this.size = size;
        board = new PieceType[size][size];
    }

    public PieceType[][] getBoard() {
        return board;
    }

    public void makeMove(int row, int col, PieceType pieceType) {
        board[row][col] = pieceType;
    }

    public boolean isCellEmpty(int row, int col) {
        return board[row][col] == null;
    }

    public int getSize() {
        return size;
    }
}