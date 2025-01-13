package Questions.ParkingLot.Sol1.repository;

import java.util.HashMap;
import java.util.Map;

public class TransactionRepository {
    private final Map<String, Double> transactions = new HashMap<>();

    public void addTransaction(String ticketId, double amount) {
        transactions.put(ticketId, amount);
    }

    public Double getTransactionAmount(String ticketId) {
        return transactions.get(ticketId);
    }
}
