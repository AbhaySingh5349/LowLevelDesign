package TicTacToe.service;

import TicTacToe.model.Board;
import TicTacToe.model.Move;

public interface Rule {
    boolean isWinningMove(Board board, Move move);
}
