package Questions.SnakesAndLadders.strategy.entity;

import Questions.SnakesAndLadders.enums.EntityType;

public interface IGameEntity {
    boolean doesSupport(EntityType entityType);
}
