package Questions.Splitwise.strategy.failed_approach;

import Questions.Splitwise.enums.CurrencyType;
import Questions.Splitwise.enums.SplitType;
import Questions.Splitwise.model.Amount;
import Questions.Splitwise.model.Currency;
import Questions.Splitwise.model.Expense;
import Questions.Splitwise.model.SplitParticipant;

import java.util.ArrayList;
import java.util.List;

public class f_EqualSplit implements f_ISplit {
    @Override
    public boolean doesSupport(f_ISplitDetails details) {
        return details.doesSupport(SplitType.EQUAL);
    }

    @Override
    public Expense support(f_ISplitDetails details) {
        Currency currency = new Currency(CurrencyType.INR, "₹");

        f_EqualSplitDetails equalSplitDetails = (f_EqualSplitDetails) details;
        List<String> commandParams = equalSplitDetails.getCommandParams();
        Double totalAmount = equalSplitDetails.getTotalAmount();
        int numParticipants = equalSplitDetails.getNumParticipants();

        double shareAmount = totalAmount/numParticipants;
        shareAmount = Math.round(shareAmount * 100.0) / 100.0;

        List<SplitParticipant> participants = new ArrayList<>();
        for(int i=0;i<numParticipants;i++){
            SplitParticipant splitParticipant = new SplitParticipant(commandParams.get(i+3), new Amount(shareAmount, currency));
            participants.add(splitParticipant);
        }

        return null;
    }
}
