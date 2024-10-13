package Questions.CoffeeMachine.strategy.validations;

public class BatteryValidation implements IValidationStrategy<Integer> {
    private final int batteryThreshold;

    public BatteryValidation(int batteryThreshold) {
        this.batteryThreshold = batteryThreshold;
    }

    @Override
    public boolean validate(Integer currentBatteryLevel) {
        return currentBatteryLevel >= batteryThreshold;
    }
}
