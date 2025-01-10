package Questions.SnakesAndLadders;

import Questions.SnakesAndLadders.repository.CellRepository;
import Questions.SnakesAndLadders.repository.LadderRepository;
import Questions.SnakesAndLadders.repository.PlayerRepository;
import Questions.SnakesAndLadders.repository.SnakeRepository;
import Questions.SnakesAndLadders.service.BoardService;
import Questions.SnakesAndLadders.service.LadderService;
import Questions.SnakesAndLadders.service.PlayerService;
import Questions.SnakesAndLadders.service.SnakeService;

import java.util.Scanner;

// board has coins
// snakes, ladders, dragon, fly
// player selection strategy
public class Main {
    public static void main(String[] args) {
        CellRepository cellRepository = new CellRepository();
        LadderRepository ladderRepository = new LadderRepository();
        LadderService ladderService = new LadderService(ladderRepository);

        SnakeRepository snakeRepository = new SnakeRepository();
        SnakeService snakeService = new SnakeService(snakeRepository);

        BoardService boardService = new BoardService(cellRepository);

        PlayerRepository playerRepository = new PlayerRepository();
        PlayerService playerService = new PlayerService(playerRepository, cellRepository);

        Scanner scanner=new Scanner(System.in);

        boardService.initializeBoard(scanner);
        playerService.initializePlayerService(scanner);
        ladderService.initializeLadderRepository(scanner);
        snakeService.initializeSnakeRepository(scanner);
    }
}
