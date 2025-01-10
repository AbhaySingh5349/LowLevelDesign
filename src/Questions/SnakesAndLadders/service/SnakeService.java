package Questions.SnakesAndLadders.service;

import Questions.SnakesAndLadders.model.Cell;
import Questions.SnakesAndLadders.repository.SnakeRepository;
import Questions.SnakesAndLadders.strategy.entity.SnakeEntityImpl;

import java.util.Scanner;

public class SnakeService {
    private final SnakeRepository snakeRepository;

    public SnakeService(SnakeRepository snakeRepository) {
        this.snakeRepository = snakeRepository;
    }

    public void initializeSnakeRepository(Scanner scanner){
        System.out.println("Enter Number of Snakes");
        int snakeNum=scanner.nextInt();
        scanner.nextLine();

        while ((snakeNum--)>0){
            String[] snakePos=scanner.nextLine().trim().split(" ");
            int head = Integer.parseInt(snakePos[0]);
            int tail = Integer.parseInt(snakePos[1]);
            snakeRepository.add(new SnakeEntityImpl(new Cell(head), new Cell(tail)));
        }
    }
}
