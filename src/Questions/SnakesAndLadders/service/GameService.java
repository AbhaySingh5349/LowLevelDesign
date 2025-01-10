package Questions.SnakesAndLadders.service;

import Questions.SnakesAndLadders.enums.EntityType;
import Questions.SnakesAndLadders.model.Cell;
import Questions.SnakesAndLadders.model.Player;
import Questions.SnakesAndLadders.repository.CellRepository;
import Questions.SnakesAndLadders.repository.SnakeRepository;
import Questions.SnakesAndLadders.strategy.entity.DiceEntityImpl;
import Questions.SnakesAndLadders.strategy.entity.IGameEntity;
import Questions.SnakesAndLadders.strategy.entity.LadderEntityImpl;
import Questions.SnakesAndLadders.strategy.entity.SnakeEntityImpl;
import Questions.SnakesAndLadders.strategy.selection.IPlayerSelection;
import Questions.SnakesAndLadders.strategy.selection.IPlayerSelectionDetails;

import java.util.List;
import java.util.Map;

public class GameService {
    private final BoardService boardService;
    private final PlayerService playerService;
    private final List<IPlayerSelection> playerSelectionList;
    private final IPlayerSelectionDetails playerSelectionDetails;
    private final List<IGameEntity> gameEntityList;
    private final IGameEntity dice;
    private final CellRepository cellRepository;
    private final SnakeRepository snakeRepository;

    public GameService(BoardService boardService, PlayerService playerService, List<IPlayerSelection> playerSelectionList, IPlayerSelectionDetails playerSelectionDetails, List<IGameEntity> gameEntityList, IGameEntity dice, CellRepository cellRepository, SnakeRepository snakeRepository) {
        this.boardService = boardService;
        this.playerService = playerService;
        this.playerSelectionList = playerSelectionList;
        this.playerSelectionDetails = playerSelectionDetails;
        this.gameEntityList = gameEntityList;
        this.dice = dice;
        this.cellRepository = cellRepository;
        this.snakeRepository = snakeRepository;
    }

    public void startGame(){
        List<Player> players = playerService.getAllPlayers();

        while (true){
            for (IPlayerSelection playerSelection : playerSelectionList) {
                int playerIdx = -1;
                if(playerSelection.doesSupport(playerSelectionDetails)){
                    playerIdx = playerSelection.support(playerSelectionDetails);
                }
                Player player = players.get(playerIdx);
                Cell updatedCell = movePlayer(player);
                if (updatedCell.getNum() >= boardService.getSize()){
                    System.out.println("Player: " + playerIdx + " won the game");
                    return;
                }
            }
        }
    }

    private Cell movePlayer(Player player) {
        DiceEntityImpl diceEntity = (DiceEntityImpl) dice;
        int num = diceEntity.roll();

        int nextCellNum = Math.min(player.getCell().getNum() + num, boardService.getSize());

        for(IGameEntity gameEntity : gameEntityList){
            if(gameEntity.doesSupport(EntityType.SNAKE)){
                List<SnakeEntityImpl> snakeEntities = snakeRepository.getAllSnakes();

                for(SnakeEntityImpl snakeEntity : snakeEntities){
                    if(snakeEntity.getHead().getNum() == nextCellNum){
                        nextCellNum = snakeEntity.getTail().getNum();
                    }
                }
            } else if (gameEntity.doesSupport(EntityType.LADDER)) {
                LadderEntityImpl ladderEntity = (LadderEntityImpl) gameEntity;
                if(ladderEntity.getBottom().getNum() == nextCellNum){
                    nextCellNum = ladderEntity.getTop().getNum();
                }
            }
        }

        Cell nextCell = cellRepository.get(nextCellNum);
        player.setCell(nextCell);

        return nextCell;
    }
}
