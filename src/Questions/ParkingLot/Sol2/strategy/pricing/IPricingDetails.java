package Questions.ParkingLot.Sol2.strategy.pricing;

import Questions.ParkingLot.Sol2.enums.PricingType;

public interface IPricingDetails {
    boolean doesSupport(PricingType pricingType);
}
