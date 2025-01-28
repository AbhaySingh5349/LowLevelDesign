package Questions.Splitwise.strategy.failed_approach;

import Questions.Splitwise.enums.SplitType;

import java.util.List;

public class f_ExactSplitDetails implements f_ISplitDetails {
    private final List<String> commandParams;
    private final int numParticipants;

    public f_ExactSplitDetails(List<String> commandParams, Double totalAmount, int numParticipants) {
        this.commandParams = commandParams;
        this.numParticipants = numParticipants;
    }

    public List<String> getCommandParams() {
        return commandParams;
    }

    public int getNumParticipants() {
        return numParticipants;
    }

    @Override
    public boolean doesSupport(SplitType splitType) {
        return splitType.equals(SplitType.EXACT);
    }
}
