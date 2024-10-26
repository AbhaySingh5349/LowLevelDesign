package Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.model;

public class Booking {
    private final String id;
    private final String userId;
    private final Ride ride;
    private final int seatsBooked;

    public Booking(String id, String userId, Ride ride, int seatsBooked) {
        this.id = id;
        this.userId = userId;
        this.ride = ride;
        this.seatsBooked = seatsBooked;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public Ride getRide() {
        return ride;
    }

    public int getSeatsBooked() {
        return seatsBooked;
    }
}
