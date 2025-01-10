package Questions.SnakesAndLadders.repository;

import Questions.SnakesAndLadders.strategy.entity.LadderEntityImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderRepository {
    private Map<Integer, LadderEntityImpl> ladderEntityMap;

    public LadderRepository() {
        this.ladderEntityMap = new HashMap<>();
    }

    public void add(LadderEntityImpl ladderEntity){
        int id = ladderEntityMap.size();
        ladderEntityMap.put(id, ladderEntity);
    }

    public List<LadderEntityImpl> getAllLadders(){
        return new ArrayList<>(ladderEntityMap.values());
    }
}
