package Questions.SnakesAndLadders.strategy.selection;

import Questions.SnakesAndLadders.enums.PlayerSelectionType;

import java.util.Random;

public class RandomPlayerSelectionImpl implements IPlayerSelection{
    @Override
    public boolean doesSupport(IPlayerSelectionDetails playerSelectionDetails) {
        return playerSelectionDetails.doesSupport(PlayerSelectionType.RANDOM);
    }

    @Override
    public int support(IPlayerSelectionDetails playerSelectionDetails) {
        RandomPlayerSelectionDetailsImpl randomPlayerSelectionDetails = (RandomPlayerSelectionDetailsImpl) playerSelectionDetails;
        int totalPlayers = randomPlayerSelectionDetails.getTotalPlayers();
        return new Random().nextInt(totalPlayers);
    }
}
