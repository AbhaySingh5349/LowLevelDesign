package Questions.SnakesAndLadders.repository;

import Questions.SnakesAndLadders.model.Cell;
import Questions.SnakesAndLadders.model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CellRepository {
    private Map<Integer, Cell> cellMap;

    public CellRepository() {
        this.cellMap = new HashMap<>();
    }

    public void add(Cell cell){
        cellMap.put(cell.getNum(), cell);
    }

    public Cell get(int num){
        return cellMap.get(num);
    }
}
