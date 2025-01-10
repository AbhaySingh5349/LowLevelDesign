package Questions.SnakesAndLadders.strategy.entity;

import Questions.SnakesAndLadders.enums.EntityType;
import Questions.SnakesAndLadders.model.Cell;

public class LadderEntityImpl implements IGameEntity {
    private final Cell top;
    private final Cell bottom;

    public LadderEntityImpl(Cell top, Cell bottom) {
        this.top = top;
        this.bottom = bottom;
    }

    public Cell getTop() {
        return top;
    }

    public Cell getBottom() {
        return bottom;
    }


    @Override
    public boolean doesSupport(EntityType entityType) {
        return entityType.equals(EntityType.LADDER);
    }
}
