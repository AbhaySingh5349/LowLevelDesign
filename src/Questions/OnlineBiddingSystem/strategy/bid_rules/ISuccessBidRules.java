package Questions.OnlineBiddingSystem.strategy.bid_rules;

import Questions.OnlineBiddingSystem.dto.BidRuleContext;
import Questions.OnlineBiddingSystem.model.Bid;

// different user + greater than prev

public interface ISuccessBidRules {
    boolean validate(BidRuleContext bidRuleContext);
}
