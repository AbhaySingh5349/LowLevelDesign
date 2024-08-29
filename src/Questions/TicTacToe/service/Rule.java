package Questions.TicTacToe.service;

import Questions.TicTacToe.model.Board;
import Questions.TicTacToe.model.Move;

public interface Rule {
    boolean isWinningMove(Board board, Move move);
}
