package Questions.SnakesAndLadders.strategy.selection;

import Questions.SnakesAndLadders.enums.PlayerSelectionType;

public class RandomPlayerSelectionDetailsImpl implements IPlayerSelectionDetails{
    private final int totalPlayers;

    public RandomPlayerSelectionDetailsImpl(int totalPlayers) {
        this.totalPlayers = totalPlayers;
    }

    public int getTotalPlayers() {
        return totalPlayers;
    }

    @Override
    public boolean doesSupport(PlayerSelectionType playerSelectionType) {
        return playerSelectionType.equals(PlayerSelectionType.RANDOM);
    }
}
