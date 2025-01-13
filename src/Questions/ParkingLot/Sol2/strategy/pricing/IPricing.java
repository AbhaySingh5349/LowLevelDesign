package Questions.ParkingLot.Sol2.strategy.pricing;

public interface IPricing {
    boolean doesSupport(IPricingDetails pricingDetails);
    int getFare(IPricingDetails pricingDetails);
}
