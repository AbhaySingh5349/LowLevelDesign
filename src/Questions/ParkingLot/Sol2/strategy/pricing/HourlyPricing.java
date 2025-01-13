package Questions.ParkingLot.Sol2.strategy.pricing;

import Questions.ParkingLot.Sol2.enums.PricingType;

public class HourlyPricing implements IPricing{
    public boolean doesSupport(IPricingDetails pricingDetails){
        return pricingDetails.doesSupport(PricingType.HOURLY);
    }

    @Override
    public int getFare(IPricingDetails pricingDetails) {
        HourlyPricingDetails hourlyPricingDetails = (HourlyPricingDetails) pricingDetails;

        int duration = hourlyPricingDetails.getDuration();
        int farePerHour = hourlyPricingDetails.getFarePerHour();

        int hours = (int) Math.ceil(duration / 60.0);

        return hours * farePerHour;
    }
}
