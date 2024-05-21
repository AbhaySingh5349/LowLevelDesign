package TicTacToe.service.implementation;

import TicTacToe.model.Board;
import TicTacToe.model.Move;
import TicTacToe.model.PieceType;
import TicTacToe.service.Rule;

public class StandardRuleImpl implements Rule {

    @Override
    public boolean isWinningMove(Board board, Move move) {
        PieceType[][] gameBoard = board.getBoard();
        PieceType pieceType = move.getPlayer().getPieceType();
        int row = move.getRow();
        int col = move.getCol();
        int size = board.getSize();

        boolean rowMatch = true;
        boolean colMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0;i<size;i++) {
            if(gameBoard[row][i] == null || gameBoard[row][i] != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in col
        for(int i=0;i<size;i++) {
            if(gameBoard[i][col] == null || gameBoard[i][col] != pieceType) {
                colMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<size;i++,j++) {
            if (gameBoard[i][j] == null || gameBoard[i][j] != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=size-1; i<size;i++,j--) {
            if (gameBoard[i][j] == null || gameBoard[i][j] != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || colMatch || diagonalMatch || antiDiagonalMatch;
    }
}
