package TicTacToe.utils;

import TicTacToe.model.Board;
import TicTacToe.model.PieceType;

public class BoardPrinter {
    public void printBoard(Board board) {
        PieceType[][] b = board.getBoard();
        for (PieceType[] row : b) {
            for (PieceType cell : row) {
                if (cell != null) {
                    System.out.print(cell.name() + "   ");
                } else {
                    System.out.print("    ");

                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }
}