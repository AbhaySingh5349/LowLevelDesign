package Questions.SnakesAndLadders.strategy.selection;

import Questions.SnakesAndLadders.enums.PlayerSelectionType;

public interface IPlayerSelectionDetails {
    boolean doesSupport(PlayerSelectionType playerSelectionType);
}
