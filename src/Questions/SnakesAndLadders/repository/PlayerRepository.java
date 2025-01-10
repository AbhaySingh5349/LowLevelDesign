package Questions.SnakesAndLadders.repository;


import Questions.SnakesAndLadders.model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerRepository {
    private Map<String, Player> playerMap;

    public PlayerRepository() {
        this.playerMap = new HashMap<>();
    }

    public void add(Player player){
        playerMap.put(player.getId(), player);
    }

    public Player get(String id){
        return playerMap.get(id);
    }

    public List<Player> getAllPlayers(){
        return new ArrayList<>(playerMap.values());
    }
}
