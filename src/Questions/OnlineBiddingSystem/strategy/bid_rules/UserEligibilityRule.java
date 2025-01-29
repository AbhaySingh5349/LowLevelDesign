package Questions.OnlineBiddingSystem.strategy.bid_rules;

import Questions.OnlineBiddingSystem.dto.BidRuleContext;
import Questions.OnlineBiddingSystem.enums.ParticipantType;
import Questions.OnlineBiddingSystem.model.Bid;
import Questions.OnlineBiddingSystem.model.Participant;

import java.util.List;
import java.util.Set;

public class UserEligibilityRule implements ISuccessBidRules{
    @Override
    public boolean validate(BidRuleContext bidRuleContext) {
        Bid bid = (Bid) bidRuleContext.get("bid");
        Set<Participant> participants = (Set<Participant>) bidRuleContext.get("participants");
        String pId = bid.getBuyerId();

        return participants.stream()
                .anyMatch(p -> p.getUser().getName().equals(pId) && p.getType() != ParticipantType.SELLER);
    }

    @Override
    public String toString() {
        return "UserEligibilityRule{}";
    }
}
