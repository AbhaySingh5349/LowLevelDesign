package Questions.Splitwise.model;

public class SplitParticipant {
    private final String userId;
    private final Amount shareAmount;

    public SplitParticipant(String userId, Amount shareAmount) {
        this.userId = userId;
        this.shareAmount = shareAmount;
    }

    public String getUserId() {
        return userId;
    }

    public Amount getShareAmount() {
        return shareAmount;
    }

    @Override
    public String toString() {
        return "SplitParticipant{" +
                "userId='" + userId + '\'' +
                ", shareAmount=" + shareAmount +
                '}';
    }
}
