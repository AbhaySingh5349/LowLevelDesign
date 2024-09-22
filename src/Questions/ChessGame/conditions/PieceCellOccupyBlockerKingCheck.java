package Questions.ChessGame.conditions;

import Questions.ChessGame.model.Board;
import Questions.ChessGame.model.Cell;
import Questions.ChessGame.model.Piece;
import Questions.ChessGame.model.Player;

// checks whether making piece move to destination cell will attract check for king
public class PieceCellOccupyBlockerKingCheck implements PieceCellOccupyBlocker{
    @Override
    public Boolean isCellAvailableForPiece(Cell destinationCell, Piece piece, Board board, Player player) {
        Cell pieceOriginalCell = piece.getCurrentCell();
        piece.setCurrentCell(destinationCell);
        boolean playerGettingCheckByMove = board.isPlayerOnCheck(player);
        piece.setCurrentCell(pieceOriginalCell);
        return !playerGettingCheckByMove;
    }
}
