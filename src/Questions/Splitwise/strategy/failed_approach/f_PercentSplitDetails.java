package Questions.Splitwise.strategy.failed_approach;

import Questions.Splitwise.enums.SplitType;

import java.util.List;

public class f_PercentSplitDetails implements f_ISplitDetails {
    private final List<String> commandParams;
    private final Double totalAmount;
    private final int numParticipants;

    public f_PercentSplitDetails(List<String> commandParams, Double totalAmount, int numParticipants) {
        this.commandParams = commandParams;
        this.totalAmount = totalAmount;
        this.numParticipants = numParticipants;
    }

    public List<String> getCommandParams() {
        return commandParams;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public int getNumParticipants() {
        return numParticipants;
    }

    @Override
    public boolean doesSupport(SplitType splitType) {
        return splitType.equals(SplitType.PERCENT);
    }
}
