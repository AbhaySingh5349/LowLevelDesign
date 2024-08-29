package Questions.ParkingLot.strategy;

public class HourlyPricing implements PricingStrategy{
    private final double hourlyRate;

    public HourlyPricing(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculatePrice(long duration) {
        return hourlyRate * Math.ceil(duration / (60.0 * 60 * 1000));
    }
}
