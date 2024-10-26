package Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.enums;

public enum VehicleType {
    SUV(8),
    SEDAN(6),
    HATCHBACK(4);

    private final int seatCount;

    VehicleType(int seatCount) {
        this.seatCount = seatCount;
    }

    public int getSeatCount() {
        return seatCount;
    }
}
