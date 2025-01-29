package Questions.OnlineBiddingSystem.model;

public class Bid {
    private final String id;
    private final String buyerId;
    private final int value;
    private final String auctionId;

    public Bid(String id, String buyerId, int value, String auctionId) {
        this.id = id;
        this.buyerId = buyerId;
        this.value = value;
        this.auctionId = auctionId;
    }

    public String getId() {
        return id;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public int getValue() {
        return value;
    }

    public String getAuctionId() {
        return auctionId;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "id='" + id + '\'' +
                ", buyerId='" + buyerId + '\'' +
                ", value=" + value +
                ", auctionId='" + auctionId + '\'' +
                '}';
    }
}
