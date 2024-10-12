package Questions.RideSharingSystem.OverallApproach.model;

import java.util.Date;

public class RideStop {
    private final Location location;
    private Date expectedArrival;

    public RideStop(Location location, Date expectedArrival) {
        this.location = location;
        this.expectedArrival = expectedArrival;
    }

    public Location getLocation() {
        return location;
    }

    public Date getExpectedArrival() {
        return expectedArrival;
    }

    public void setExpectedArrival(Date expectedArrival) {
        this.expectedArrival = expectedArrival;
    }
}
