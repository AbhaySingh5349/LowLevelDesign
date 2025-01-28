package Questions.Splitwise.strategy.failed_approach;

import Questions.Splitwise.enums.CurrencyType;
import Questions.Splitwise.enums.SplitType;
import Questions.Splitwise.model.Amount;
import Questions.Splitwise.model.Currency;
import Questions.Splitwise.model.Expense;
import Questions.Splitwise.model.SplitParticipant;

import java.util.ArrayList;
import java.util.List;

public class f_ExactSplit implements f_ISplit {
    @Override
    public boolean doesSupport(f_ISplitDetails details) {
        return details.doesSupport(SplitType.EXACT);
    }

    @Override
    public Expense support(f_ISplitDetails details) {
        Currency currency = new Currency(CurrencyType.INR, "₹");

        f_ExactSplitDetails exactSplitDetails = (f_ExactSplitDetails) details;
        List<String> commandParams = exactSplitDetails.getCommandParams();
        int numParticipants = exactSplitDetails.getNumParticipants();

        List<SplitParticipant> participants = new ArrayList<>();
        for(int i=0;i<numParticipants;i++){
            double shareAmount = Double.parseDouble(commandParams.get(numParticipants+4+i));
            SplitParticipant splitParticipant = new SplitParticipant(commandParams.get(i+3), new Amount(shareAmount, currency));
            participants.add(splitParticipant);
        }

        return null;
    }
}
