package Questions.SnakesAndLadders.strategy.entity;

import Questions.SnakesAndLadders.enums.EntityType;

import java.util.Random;

public class DiceEntityImpl implements IGameEntity {
    private final int numFaces;

    public DiceEntityImpl(int numFaces) {
        this.numFaces = numFaces;
    }

    public int getNumFaces() {
        return numFaces;
    }

    public int roll(){
        return new Random().nextInt(1, numFaces+1);
    }

    @Override
    public boolean doesSupport(EntityType entityType) {
        return entityType.equals(EntityType.Dice);
    }
}
