package Questions.ChessGame.conditions;

import Questions.ChessGame.enums.PieceType;
import Questions.ChessGame.model.Piece;

// allows a move only if cell is making a move from its initial position. That is first move ever.
// since Pawn can take 1 or 2 steps in 1st move else can only take 1 step
public class MoveBaseConditionFirstMove implements MoveBaseCondition {
    @Override
    public Boolean isBaseConditionFullFilled(Piece piece) {
        return piece.getNumMoves() == 0 && piece.getPieceType().equals(PieceType.PAWN);
    }
}
