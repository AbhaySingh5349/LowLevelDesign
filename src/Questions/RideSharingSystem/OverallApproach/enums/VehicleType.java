package Questions.RideSharingSystem.OverallApproach.enums;

public enum VehicleType {
    HATCH_BACK(4),
    SEDAN(6),
    SUV(8);

    private final int defaultSeats;

    VehicleType(int defaultSeats) {
        this.defaultSeats = defaultSeats;
    }

    public int getDefaultSeats() {
        return defaultSeats;
    }
}
