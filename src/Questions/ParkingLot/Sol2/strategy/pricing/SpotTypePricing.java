package Questions.ParkingLot.Sol2.strategy.pricing;

import Questions.ParkingLot.Sol2.enums.PricingType;
import Questions.ParkingLot.Sol2.enums.SpotType;

public class SpotTypePricing implements IPricing{
    @Override
    public boolean doesSupport(IPricingDetails pricingDetails) {
        return pricingDetails.doesSupport(PricingType.SPOT_TYPE);
    }

    @Override
    public int getFare(IPricingDetails pricingDetails) {
        SpotTypePricingDetails spotTypePricingDetails = (SpotTypePricingDetails) pricingDetails;

        SpotType spotType = spotTypePricingDetails.getSpotType();

        return getBasePriceForSpotType(spotType);
    }

    private int getBasePriceForSpotType(SpotType spotType) {
        return switch (spotType){
            case CAR -> 5;
            case BIKE -> 2;
            case E_VEHICLE -> 4;
            case TRUCK -> 10;
        };
    }
}
