package Questions.Splitwise.storage;

import Questions.Splitwise.model.Expense;

import java.util.*;

public class InMemoryExpenseStorage implements IExpenseStorage{
    private final Map<String, Map<String, Double>> userBalanceMap;
    private final Map<String, Double> userOverallBalanceMap;
    private final List<Expense> expenses;

    public InMemoryExpenseStorage() {
        this.userBalanceMap = new HashMap<>();
        this.userOverallBalanceMap = new HashMap<>();
        this.expenses = new ArrayList<>();
    }

    @Override
    public void updateBalance(String userId1, String userId2, double amount) {
        userBalanceMap.computeIfAbsent(userId1, k -> new HashMap<>()).merge(userId2, amount, Double::sum);
    }

    @Override
    public double getBalanceBetweenUsers(String userId1, String userId2) {
        return userBalanceMap.getOrDefault(userId1, Collections.emptyMap())
                .getOrDefault(userId2, 0.0);
    }

    @Override
    public void updateOverallBalance(String userId, double amount) {
        userOverallBalanceMap.put(userId, userOverallBalanceMap.getOrDefault(userId, 0.0) + amount);
//        userOverallBalanceMap.merge(userId, amount, Double::sum);
    }

    @Override
    public double getOverallBalance(String userId) {
        return userOverallBalanceMap.getOrDefault(userId, 0.0);
    }

    @Override
    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return new ArrayList<>(expenses);
    }
}
