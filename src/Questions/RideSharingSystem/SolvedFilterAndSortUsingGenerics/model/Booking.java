package Questions.RideSharingSystem.SolvedFilterAndSortUsingGenerics.model;

public class Booking {
    private String id;
    private final String rideId;
    private final String passengerId;
    private final int seatsBooked;

    public Booking(String rideId, String passengerId, int seatsBooked) {
        this.rideId = rideId;
        this.passengerId = passengerId;
        this.seatsBooked = seatsBooked;
    }

    public String getId() {
        return id;
    }

    public String getRideId() {
        return rideId;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public int getSeatsBooked() {
        return seatsBooked;
    }

    public void setId(String id) {
        this.id = id;
    }
}
