package Questions.Splitwise;

// EXPENSE u1 1000 4 u1 u2 u3 u4 EQUAL
// EXPENSE u1 1250 2 u2 u3 EXACT 370 880
// EXPENSE u4 1200 4 u1 u2 u3 u4 PERCENT 40 20 20 20

import Questions.Splitwise.service.ExpenseService;
import Questions.Splitwise.repository.IExpenseStorage;
import Questions.Splitwise.repository.InMemoryExpenseStorage;
import Questions.Splitwise.strategy.correct_approach.EqualSplit;
import Questions.Splitwise.strategy.correct_approach.ExactSplit;
import Questions.Splitwise.strategy.correct_approach.ISplit;
import Questions.Splitwise.strategy.correct_approach.PercentSplit;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ISplit> splits = Arrays.asList(new EqualSplit(), new ExactSplit(), new PercentSplit());
        IExpenseStorage storage = new InMemoryExpenseStorage();

        ExpenseService expenseService = new ExpenseService(splits, storage);
        expenseService.execute("EXPENSE u1 1000 4 u1 u2 u3 u4 EQUAL");

        System.out.println("Lend/Borrow between user1 and user2: " + expenseService.getLendOrBorrow("u1", "u2"));
        System.out.println("Overall balance of user1: " + expenseService.getOverallBalance("u1"));
        System.out.println("All expenses: " + expenseService.getAllExpenses());
    }
}
