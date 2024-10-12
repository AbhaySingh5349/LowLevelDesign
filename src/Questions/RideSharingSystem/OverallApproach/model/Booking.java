package Questions.RideSharingSystem.OverallApproach.model;

import java.util.Date;

public class Booking {
    private final Ride ride;
    private final User bookedBy;
    private final Integer seatsBooked;
    private final Location startLocation;
    private final Location endLocation;
    private final Date createdAt;

    public Booking(Ride ride, User bookedBy, Integer seatsBooked, Location startLocation, Location endLocation) {
        this.ride = ride;
        this.bookedBy = bookedBy;
        this.seatsBooked = seatsBooked;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.createdAt = new Date();
    }

    public Ride getRide() {
        return ride;
    }

    public User getBookedBy() {
        return bookedBy;
    }

    public Integer getSeatsBooked() {
        return seatsBooked;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public Location getEndLocation() {
        return endLocation;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
