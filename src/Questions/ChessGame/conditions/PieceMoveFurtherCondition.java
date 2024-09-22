package Questions.ChessGame.conditions;

import Questions.ChessGame.model.Board;
import Questions.ChessGame.model.Cell;
import Questions.ChessGame.model.Piece;

public interface PieceMoveFurtherCondition {
    Boolean canPieceMoveFurtherFromCell(Piece piece, Cell cell, Board board);
}