package Questions.SnakesAndLadders.strategy.entity;

import Questions.SnakesAndLadders.enums.EntityType;
import Questions.SnakesAndLadders.model.Cell;

public class SnakeEntityImpl implements IGameEntity {
    private final Cell head;
    private final Cell tail;

    public SnakeEntityImpl(Cell head, Cell tail) {
        this.head = head;
        this.tail = tail;
    }

    public Cell getHead() {
        return head;
    }

    public Cell getTail() {
        return tail;
    }

    @Override
    public boolean doesSupport(EntityType entityType) {
        return entityType.equals(EntityType.SNAKE);
    }
}
