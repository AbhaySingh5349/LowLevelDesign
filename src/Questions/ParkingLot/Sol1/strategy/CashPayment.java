package Questions.ParkingLot.Sol1.strategy;

public class CashPayment implements PaymentStrategy{
    @Override
    public Boolean pay(double amount) {
        System.out.println("Paid " + amount + " in cash.");
        return true;
    }
}
