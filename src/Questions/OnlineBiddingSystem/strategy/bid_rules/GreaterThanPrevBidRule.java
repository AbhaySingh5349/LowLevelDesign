package Questions.OnlineBiddingSystem.strategy.bid_rules;

import Questions.OnlineBiddingSystem.dto.BidRuleContext;
import Questions.OnlineBiddingSystem.model.Bid;

public class GreaterThanPrevBidRule implements ISuccessBidRules{
    @Override
    public boolean validate(BidRuleContext bidRuleContext) {
        Bid bid = (Bid) bidRuleContext.get("bid");
        Bid currentMaxBid = (Bid) bidRuleContext.get("currentMaxBid");

        return bid.getValue() > currentMaxBid.getValue();
    }

    @Override
    public String toString() {
        return "GreaterThanPrevBidRule{}";
    }
}
