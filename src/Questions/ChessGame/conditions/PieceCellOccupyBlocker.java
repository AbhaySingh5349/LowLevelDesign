package Questions.ChessGame.conditions;

import Questions.ChessGame.model.Board;
import Questions.ChessGame.model.Cell;
import Questions.ChessGame.model.Piece;
import Questions.ChessGame.model.Player;

// check whether a piece can occupy a given cell in the board or not
// since cells between src & dst should be free & dst cell should have opponent cell or free
public interface PieceCellOccupyBlocker {
    Boolean isCellAvailableForPiece(Cell destinationCell, Piece piece, Board board, Player player);
}
