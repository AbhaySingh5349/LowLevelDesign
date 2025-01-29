package Questions.OnlineBiddingSystem.strategy.actions;

import Questions.OnlineBiddingSystem.enums.ParticipantType;

public class PlaceBidActionDetails implements IActionDetails{
    private final String userId;
    private final String auctionId;
    private final String itemId;
    private final int amount;

    public PlaceBidActionDetails(String userId, String auctionId, String itemId, int amount) {
        this.userId = userId;
        this.auctionId = auctionId;
        this.itemId = itemId;
        this.amount = amount;
    }

    public String getUserId() {
        return userId;
    }

    public String getAuctionId() {
        return auctionId;
    }

    public String getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean doesSupport(ParticipantType type) {
        return type.equals(ParticipantType.BUYER);
    }
}
