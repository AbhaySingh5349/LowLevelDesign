package Questions.SnakesAndLadders.strategy.selection;

import Questions.SnakesAndLadders.enums.PlayerSelectionType;

public class RoundRobinPlayerSelectionImpl implements IPlayerSelection{
    @Override
    public boolean doesSupport(IPlayerSelectionDetails playerSelectionDetails) {
        return playerSelectionDetails.doesSupport(PlayerSelectionType.ROUND_ROBIN);
    }

    @Override
    public int support(IPlayerSelectionDetails playerSelectionDetails) {
        RoundRobinPlayerSelectionDetailsImpl roundRobinPlayerSelectionDetails = (RoundRobinPlayerSelectionDetailsImpl) playerSelectionDetails;
        int totalPlayers = roundRobinPlayerSelectionDetails.getTotalPlayers();
        int prevPlayerIdx = roundRobinPlayerSelectionDetails.getPrevPlayerIdx();

        int nextPlayerIdx = (prevPlayerIdx+1)%totalPlayers;

        roundRobinPlayerSelectionDetails.setPrevPlayerIdx(nextPlayerIdx);
        return nextPlayerIdx;
    }
}
