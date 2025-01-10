package Questions.SnakesAndLadders.strategy.selection;

import Questions.SnakesAndLadders.enums.PlayerSelectionType;

public interface IPlayerSelection {
    boolean doesSupport(IPlayerSelectionDetails playerSelectionDetails);
    int support(IPlayerSelectionDetails playerSelectionDetails);
}
