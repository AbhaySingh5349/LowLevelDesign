package Questions.ChessGame.conditions;

import Questions.ChessGame.model.Board;
import Questions.ChessGame.model.Cell;
import Questions.ChessGame.model.Piece;
import Questions.ChessGame.model.Player;

// check that a cell can be occupied if that cell is free or not occupied by same players other piece
public class PieceCellOccupyBlockerSelfPiece implements PieceCellOccupyBlocker{
    @Override
    public Boolean isCellAvailableForPiece(Cell destinationCell, Piece piece, Board board, Player player) {
        if(destinationCell.isFree()){
            return true;
        }

        Piece destinationPiece = destinationCell.getCurrentPiece();

        return !destinationPiece.getColor().equals(piece.getColor());
    }
}
