package Questions.ChessGame.conditions;

import Questions.ChessGame.model.Piece;

// provides base condition for a piece to make a move.
// The piece would only be allowed to move from its current position if the condition fulfills.
public interface MoveBaseCondition {
    Boolean isBaseConditionFullFilled(Piece piece);
}
