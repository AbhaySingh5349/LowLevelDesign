package TicTacToe;

import TicTacToe.controller.GameController;
import TicTacToe.model.PieceType;
import TicTacToe.model.Player;

public class Main {
    public static void main(String[] args){
        int boardSize = 3;  // Standard Tic-Tac-Toe board size is 3x3
        GameController gameController = new GameController(boardSize);

        gameController.playGame();
    }
}
