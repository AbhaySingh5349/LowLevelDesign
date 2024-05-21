package TicTacToe.service.implementation;

import TicTacToe.model.Board;
import TicTacToe.model.Move;
import TicTacToe.service.GameService;
import TicTacToe.service.Rule;

public class GameServiceImpl implements GameService {
    private final Board board;
    private final Rule rule;

    public GameServiceImpl(Board board, Rule rule) {
        this.board = board;
        this.rule = rule;
    }

    @Override
    public void makeMove(Move move) {
        if (board.isCellEmpty(move.getRow(), move.getCol())) {
            board.makeMove(move.getRow(), move.getCol(), move.getPlayer().getPieceType());
        } else {
            throw new IllegalArgumentException("Cell is already occupied!");
        }
    }

    @Override
    public boolean checkWin(Move move) {
        return rule.isWinningMove(board, move);
    }

    public Board getBoard() {
        return  this.board;
    }
}
