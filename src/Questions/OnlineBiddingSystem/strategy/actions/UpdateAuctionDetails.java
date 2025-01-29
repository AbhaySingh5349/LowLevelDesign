package Questions.OnlineBiddingSystem.strategy.actions;

import Questions.OnlineBiddingSystem.enums.AuctionStatus;
import Questions.OnlineBiddingSystem.enums.ParticipantType;

import java.time.LocalDate;
import java.util.Optional;

public class UpdateAuctionDetails implements IActionDetails{
    private Optional<String> itemName = Optional.empty();
    private Optional<LocalDate> start = Optional.empty();
    private Optional<LocalDate> end = Optional.empty();
    private Optional<AuctionStatus> status = Optional.empty();

    public Optional<String> getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = Optional.ofNullable(itemName);
    }

    public Optional<LocalDate> getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = Optional.ofNullable(start);
    }

    public Optional<LocalDate> getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = Optional.ofNullable(end);
    }

    public Optional<AuctionStatus> getStatus() {
        return status;
    }

    public void setStatus(AuctionStatus status) {
        this.status = Optional.ofNullable(status);
    }

    @Override
    public boolean doesSupport(ParticipantType type) {
        return type.equals(ParticipantType.SELLER);
    }
}
