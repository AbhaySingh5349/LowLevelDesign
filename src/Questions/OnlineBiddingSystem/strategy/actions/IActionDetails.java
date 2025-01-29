package Questions.OnlineBiddingSystem.strategy.actions;

import Questions.OnlineBiddingSystem.enums.ParticipantType;

public interface IActionDetails {
    boolean doesSupport(ParticipantType type);
}
