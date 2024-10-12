package Questions.RideSharingSystem.SolvedFilterAndSort.enums;

public enum VehicleType {
    HATCH_BACK(4),
    SEDAN(6),
    SUV(8);

    private final int seats;
    VehicleType(int seats) {
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }
}
