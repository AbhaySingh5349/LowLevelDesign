package Questions.RideSharingSystem.repository;

import Questions.RideSharingSystem.model.Ride;

import java.util.List;

public interface IRideRepo {
    String add(Ride ride);
    Ride get(String rideId);
    Ride update(String rideId);
    List<Ride> getAllRides();
}
