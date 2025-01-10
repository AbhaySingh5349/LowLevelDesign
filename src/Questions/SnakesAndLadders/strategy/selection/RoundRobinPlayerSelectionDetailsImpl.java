package Questions.SnakesAndLadders.strategy.selection;

import Questions.SnakesAndLadders.enums.PlayerSelectionType;

public class RoundRobinPlayerSelectionDetailsImpl implements IPlayerSelectionDetails{
    private final int totalPlayers;
    private int prevPlayerIdx;

    public RoundRobinPlayerSelectionDetailsImpl(int totalPlayers, int prevPlayerIdx) {
        this.totalPlayers = totalPlayers;
        this.prevPlayerIdx = prevPlayerIdx;
    }

    public int getTotalPlayers() {
        return totalPlayers;
    }

    public int getPrevPlayerIdx() {
        return prevPlayerIdx;
    }

    public void setPrevPlayerIdx(int prevPlayerIdx) {
        this.prevPlayerIdx = prevPlayerIdx;
    }

    @Override
    public boolean doesSupport(PlayerSelectionType playerSelectionType) {
        return playerSelectionType.equals(PlayerSelectionType.ROUND_ROBIN);
    }
}
