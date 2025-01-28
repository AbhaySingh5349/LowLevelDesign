package Questions.Splitwise.model;

import java.util.List;

// to keep track of money lend or borrowed
public class Expense {
    private final String payerId;
    private final double totalAmount;
    private final List<SplitParticipant> participants;

    public Expense(String payerId, double totalAmount, List<SplitParticipant> participants) {
        this.payerId = payerId;
        this.totalAmount = totalAmount;
        this.participants = participants;
    }

    public String getPayerId() {
        return payerId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public List<SplitParticipant> getParticipants() {
        return participants;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "payerId='" + payerId + '\'' +
                ", totalAmount=" + totalAmount +
                ", participants=" + participants +
                '}';
    }
}
