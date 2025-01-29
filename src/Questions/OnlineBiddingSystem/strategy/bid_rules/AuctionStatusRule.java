package Questions.OnlineBiddingSystem.strategy.bid_rules;

import Questions.OnlineBiddingSystem.dto.BidRuleContext;
import Questions.OnlineBiddingSystem.enums.AuctionStatus;
import Questions.OnlineBiddingSystem.model.Auction;

public class AuctionStatusRule implements ISuccessBidRules{
    @Override
    public boolean validate(BidRuleContext bidRuleContext) {
        Auction auction = (Auction) bidRuleContext.get("auction");
        return auction.getStatus() == AuctionStatus.IN_PROGRESS;
    }

    @Override
    public String toString() {
        return "AuctionStatusRule{}";
    }
}
