package Questions.TicTacToe.service;

import Questions.TicTacToe.model.Board;
import Questions.TicTacToe.model.Move;

public interface GameService {
    Board getBoard();
    void makeMove(Move move);
    boolean checkWin(Move move);
}
