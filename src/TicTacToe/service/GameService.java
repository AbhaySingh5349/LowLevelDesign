package TicTacToe.service;

import TicTacToe.model.Board;
import TicTacToe.model.Move;

public interface GameService {
    Board getBoard();
    void makeMove(Move move);
    boolean checkWin(Move move);
}
