package Questions.ParkingLot.strategy;

public interface PricingStrategy {
    double calculatePrice(long duration);
}