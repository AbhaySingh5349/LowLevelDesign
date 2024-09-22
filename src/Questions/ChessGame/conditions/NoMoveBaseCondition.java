package Questions.ChessGame.conditions;

import Questions.ChessGame.model.Piece;

public class NoMoveBaseCondition implements MoveBaseCondition{
    @Override
    public Boolean isBaseConditionFullFilled(Piece piece) {
        return true;
    }
}
