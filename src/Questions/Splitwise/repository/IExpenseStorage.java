package Questions.Splitwise.repository;

import Questions.Splitwise.model.Expense;

import java.util.List;

public interface IExpenseStorage {
    // Methods for managing balances
    void updateBalance(String userId1, String userId2, double amount);
    double getBalanceBetweenUsers(String userId1, String userId2);
    void updateOverallBalance(String userId, double amount);
    double getOverallBalance(String userId);

    // Methods for managing expenses
    void addExpense(Expense expense);
    List<Expense> getAllExpenses();
}
