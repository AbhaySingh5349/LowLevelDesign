package Questions.OnlineBiddingSystem.model;

import Questions.OnlineBiddingSystem.enums.AuctionStatus;

import java.time.LocalDate;

public class Auction {
    private final String id;
    private String itemName;
    private LocalDate start;
    private LocalDate end;
    private AuctionStatus status;

    public Auction(String id, String itemName, LocalDate start, LocalDate end) {
        this.id = id;
        this.itemName = itemName;
        this.start = start;
        this.end = end;
        this.status = AuctionStatus.SCHEDULED;
    }

    public String getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public AuctionStatus getStatus() {
        return status;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public void setStatus(AuctionStatus status) {
        this.status = status;
    }
}
