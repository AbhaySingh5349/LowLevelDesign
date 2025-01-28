package Questions.Splitwise.service;

import Questions.Splitwise.enums.CommandType;
import Questions.Splitwise.enums.SplitType;
import Questions.Splitwise.model.Expense;
import Questions.Splitwise.model.SplitParticipant;
import Questions.Splitwise.model.User;
import Questions.Splitwise.storage.IExpenseStorage;
import Questions.Splitwise.strategy.correct_approach.ISplit;

import java.util.Arrays;
import java.util.List;

import static Questions.Splitwise.enums.CommandType.SHOW;

// we cannot use ISplitDetails & doesSupport(ISplitDetails)
// because data required by them is different which can only be known once we parse expression

public class ExpenseService {
    private final IExpenseStorage storage;
    private final List<ISplit> splits;
    private final String cmdDelimiter;

    public ExpenseService(List<ISplit> splits, IExpenseStorage storage) {
        this.splits = splits;
        this.storage = storage;
        this.cmdDelimiter = " ";
    }

    public void execute(String command){
        String[] expenseData = command.split(cmdDelimiter);

        CommandType commandType = CommandType.valueOf(expenseData[0]);

        List<String> commandParams = Arrays.asList(expenseData).subList(1, expenseData.length);

        switch (commandType){
            case EXPENSE:
                /*
                for (f_ISplit split : splits){
                    if (split.doesSupport(splitDetails)){
                        // but we don't have split details beforehand
                    }
                }
                */
                int numParticipants = Integer.parseInt(commandParams.get(2));
                SplitType splitType = SplitType.valueOf(commandParams.get(numParticipants+3));

                ISplit splitStrategy = null;
                for(ISplit split : splits){
                    if(split.doesSupport(splitType)){
                        splitStrategy = split;
                        break;
                    }
                }

                Expense expense = splitStrategy.support(commandParams);
                addExpense(expense);
                System.out.println(expense.toString());

                break;
            case SHOW:
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + commandType);
        }
    }

    private void addExpense(Expense expense) {
        String payerId = expense.getPayerId();
        List<SplitParticipant> participants = expense.getParticipants();

        storage.addExpense(expense);

        for (SplitParticipant participant : participants) {
            String participantId = participant.getUserId();
            double shareAmount = participant.getShareAmount().getValue();

            // Update balances
            storage.updateBalance(payerId, participantId, shareAmount);
            storage.updateBalance(participantId, payerId, -shareAmount);

            // Update overall balances
            storage.updateOverallBalance(payerId, shareAmount);
            storage.updateOverallBalance(participantId, -shareAmount);
        }
    }

    // Get how much one user lends/borrows from another
    public String getLendOrBorrow(String userId1, String userId2) {
        double balance = storage.getBalanceBetweenUsers(userId1, userId2);

        if (balance > 0) {
            // userId2 owes userId1
            return userId2 + " owes " + userId1 + " an amount of " + String.format("%.2f", balance);
        } else if (balance < 0) {
            // userId1 owes userId2
            return userId1 + " owes " + userId2 + " an amount of " + String.format("%.2f", Math.abs(balance));
        } else {
            // No balance between the two
            return userId1 + " and " + userId2 + " are settled up.";
        }
    }

    // Get overall balance of a user
    public double getOverallBalance(String userId) {
        return storage.getOverallBalance(userId);
    }

    // Get all expenses
    public List<Expense> getAllExpenses() {
        return storage.getAllExpenses();
    }
}
