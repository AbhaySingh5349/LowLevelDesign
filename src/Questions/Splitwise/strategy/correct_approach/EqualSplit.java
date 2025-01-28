package Questions.Splitwise.strategy.correct_approach;

import Questions.Splitwise.enums.CurrencyType;
import Questions.Splitwise.enums.SplitType;
import Questions.Splitwise.model.Amount;
import Questions.Splitwise.model.Currency;
import Questions.Splitwise.model.Expense;
import Questions.Splitwise.model.SplitParticipant;

import java.util.ArrayList;
import java.util.List;

public class EqualSplit implements ISplit{
    @Override
    public boolean doesSupport(SplitType splitType) {
        return splitType.equals(SplitType.EQUAL);
    }

    @Override
    public Expense support(List<String> commandParams) {
        Currency currency = new Currency(CurrencyType.INR, "₹");

        String payerId = commandParams.get(0);
        double totalAmount = Double.parseDouble(commandParams.get(1));
        int numParticipants = Integer.parseInt(commandParams.get(2));

        double shareAmount = totalAmount/numParticipants;
        shareAmount = Math.round(shareAmount * 100.0) / 100.0;

        List<SplitParticipant> participants = new ArrayList<>();
        for(int i=0;i<numParticipants;i++){
            SplitParticipant splitParticipant = new SplitParticipant(commandParams.get(i+3), new Amount(shareAmount, currency));
            participants.add(splitParticipant);
        }

        return new Expense(payerId, totalAmount, participants);
    }
}
