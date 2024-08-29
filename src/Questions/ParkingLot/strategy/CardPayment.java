package Questions.ParkingLot.strategy;

public class CardPayment implements PaymentStrategy{
    @Override
    public Boolean pay(double amount) {
        System.out.println("Paid " + amount + " using a card.");
        return true;
    }
}
