package Questions.ParkingLot.Sol2.strategy.pricing;

import Questions.ParkingLot.Sol2.enums.PricingType;
import Questions.ParkingLot.Sol2.enums.SpotType;

public class SpotTypePricingDetails implements IPricingDetails{
    private final SpotType spotType;

    public SpotTypePricingDetails(SpotType spotType) {
        this.spotType = spotType;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    @Override
    public boolean doesSupport(PricingType pricingType) {
        return pricingType.equals(PricingType.SPOT_TYPE);
    }
}
