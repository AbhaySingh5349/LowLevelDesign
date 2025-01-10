package Questions.SnakesAndLadders.repository;

import Questions.SnakesAndLadders.strategy.entity.SnakeEntityImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeRepository {
    private final Map<Integer, SnakeEntityImpl> snakeEntityMap;

    public SnakeRepository() {
        this.snakeEntityMap = new HashMap<>();
    }

    public void add(SnakeEntityImpl snakeEntity){
        int id = snakeEntityMap.size();
        snakeEntityMap.put(id, snakeEntity);
    }

    public List<SnakeEntityImpl> getAllSnakes(){
        return new ArrayList<>(snakeEntityMap.values());
    }
}
