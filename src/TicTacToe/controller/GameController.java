package TicTacToe.controller;

import TicTacToe.model.Board;
import TicTacToe.model.Move;
import TicTacToe.model.Player;
import TicTacToe.service.GameService;
import TicTacToe.service.implementation.GameServiceImpl;
import TicTacToe.service.implementation.StandardRuleImpl;
import TicTacToe.utils.BoardPrinter;

import java.util.Scanner;

public class GameController {
    private final GameService gameService;
    private final BoardPrinter boardPrinter;
    private final int boardSize;

    public GameController(int boardSize) {
        this.boardSize = boardSize;
        Board board = new Board(boardSize);
        gameService = new GameServiceImpl(board, new StandardRuleImpl());
        boardPrinter = new BoardPrinter();
    }

    public void playGame(Player player1, Player player2) {
        Scanner scanner = new Scanner(System.in);
        Player currentPlayer = player1;
        boolean gameWon = false;
        int totalMoves = boardSize * boardSize;
        int movesMade = 0;

        while (movesMade < totalMoves && !gameWon) {
            boardPrinter.printBoard(((GameServiceImpl) gameService).getBoard());
            System.out.println(currentPlayer.getName() + "'s turn. Enter row and column (0-based): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (row < 0 || col < 0 || row >= boardSize || col >= boardSize) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            Move move = new Move(row, col, currentPlayer);
            try {
                gameService.makeMove(move);
                movesMade++;
                if (gameService.checkWin(move)) {
                    gameWon = true;
                    boardPrinter.printBoard(((GameServiceImpl) gameService).getBoard());
                    System.out.println("Congratulations " + currentPlayer.getName() + "! You have won the game.");
                } else {
                    currentPlayer = (currentPlayer == player1) ? player2 : player1;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        if (!gameWon) {
            boardPrinter.printBoard(((GameServiceImpl) gameService).getBoard());
            System.out.println("The game is a draw.");
        }

        scanner.close();
    }
}
