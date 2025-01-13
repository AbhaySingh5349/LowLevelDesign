package Questions.ParkingLot.Sol2.strategy.pricing;

import Questions.ParkingLot.Sol2.enums.PricingType;

public class HourlyPricingDetails implements IPricingDetails{
    private final int duration;
    private final int FARE_PER_HOUR= 5;

    public HourlyPricingDetails(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public int getFarePerHour() {
        return FARE_PER_HOUR;
    }

    @Override
    public boolean doesSupport(PricingType pricingType) {
        return pricingType.equals(PricingType.HOURLY);
    }
}
