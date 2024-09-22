package Questions.ChessGame;

import Questions.ChessGame.conditions.NoMoveBaseCondition;
import Questions.ChessGame.conditions.PieceCellOccupyBlockerSelfPiece;
import Questions.ChessGame.conditions.PieceMoveFurtherConditionDefault;
import Questions.ChessGame.enums.Color;
import Questions.ChessGame.enums.PieceType;
import Questions.ChessGame.model.Board;
import Questions.ChessGame.model.Piece;
import Questions.ChessGame.model.Player;
import Questions.ChessGame.moves.PossibleMovesProviderHorizontal;

import java.util.List;

public class GameController {
    public static void gameplay(List<Player> players, Board board) {
        Piece pawn = new Piece(Color.WHITE,
                                PieceType.PAWN,
                                List.of(new PossibleMovesProviderHorizontal(1, new NoMoveBaseCondition(), new PieceMoveFurtherConditionDefault(), new PieceCellOccupyBlockerSelfPiece())));
        int currentPlayer = 0;
        while (true) {
            Player player = players.get(currentPlayer);
            //TODO: Check if current player has any move possible. If no move possible, then its checkmate.
            PlayerMove playerMove = player.makeMove();
            playerMove.getPiece().move(player, playerMove.getToCell(), board, defaultAdditionalBlockers());
            currentPlayer = (currentPlayer + 1) % players.size();
        }
    }
}
