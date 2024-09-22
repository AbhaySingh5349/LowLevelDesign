package Questions.ChessGame.moves;

import Questions.ChessGame.conditions.MoveBaseCondition;
import Questions.ChessGame.conditions.PieceCellOccupyBlocker;
import Questions.ChessGame.conditions.PieceMoveFurtherCondition;
import Questions.ChessGame.model.Board;
import Questions.ChessGame.model.Cell;
import Questions.ChessGame.model.Piece;
import Questions.ChessGame.model.Player;

import java.util.List;

public class PossibleMovesProviderDiagonal extends PossibleMovesProvider{
    public PossibleMovesProviderDiagonal(Integer maxMoves, MoveBaseCondition moveBaseCondition, PieceMoveFurtherCondition pieceMoveFurtherCondition, PieceCellOccupyBlocker pieceCellOccupyBlocker) {
        super(maxMoves, moveBaseCondition, pieceMoveFurtherCondition, pieceCellOccupyBlocker);
    }

    @Override
    protected List<Cell> possibleMovesAsPerCurrentType(Piece piece, Board board, List<PieceCellOccupyBlocker> additionalBlockers, Player player) {
        return List.of();
    }
}
