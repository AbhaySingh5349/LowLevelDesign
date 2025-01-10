package Questions.SnakesAndLadders.service;

import Questions.SnakesAndLadders.model.Player;
import Questions.SnakesAndLadders.repository.CellRepository;
import Questions.SnakesAndLadders.repository.PlayerRepository;

import java.util.List;
import java.util.Scanner;

public class PlayerService {
    private final PlayerRepository playerRepository;
    private final CellRepository cellRepository;

    public PlayerService(PlayerRepository playerRepository, CellRepository cellRepository) {
        this.playerRepository = playerRepository;
        this.cellRepository = cellRepository;
    }

    public void initializePlayerService(Scanner scanner){
        System.out.println("Enter Number of Players & Their ids");
        int playerNum=scanner.nextInt();
        scanner.nextLine();
        while ((playerNum--)>0){
            String id = scanner.nextLine();

            Player player = new Player(id, cellRepository.get(0));
            playerRepository.add(player);
        }
    }

    public List<Player> getAllPlayers(){
        return playerRepository.getAllPlayers();
    }
}
