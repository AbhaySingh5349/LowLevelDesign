package Questions.SnakesAndLadders.service;

import Questions.SnakesAndLadders.model.Cell;
import Questions.SnakesAndLadders.repository.LadderRepository;
import Questions.SnakesAndLadders.strategy.entity.IGameEntity;
import Questions.SnakesAndLadders.strategy.entity.LadderEntityImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class LadderService {
    private final LadderRepository ladderRepository;

    public LadderService(LadderRepository ladderRepository) {
        this.ladderRepository = ladderRepository;
    }

    public void initializeLadderRepository(Scanner scanner){
        System.out.println("Enter Number of Ladders");

        int ladderNum=scanner.nextInt();
        scanner.nextLine();

        while ((ladderNum--)>0){
            String[] ladderPos=scanner.nextLine().split(" ");
            int top = Integer.parseInt(ladderPos[0]);
            int bottom = Integer.parseInt(ladderPos[1]);

            ladderRepository.add(new LadderEntityImpl(new Cell(top), new Cell(bottom)));
        }
    }
}
