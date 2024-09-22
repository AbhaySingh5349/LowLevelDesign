package Questions.ChessGame.model;

import Questions.ChessGame.enums.PieceType;
import Questions.ChessGame.exceptions.PieceNotFoundException;

import java.util.List;

public class Player {
    private final List<Piece> pieces;

    public Player(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public Piece getPiece(PieceType pieceType) {
        for (Piece piece : pieces) {
            if (piece.getPieceType() == pieceType) {
                return piece;
            }
        }
        throw new PieceNotFoundException();
    }

    public void makeMove(PieceType pieceType){

    }
}
