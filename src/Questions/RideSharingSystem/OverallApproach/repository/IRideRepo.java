package Questions.RideSharingSystem.OverallApproach.repository;

import Questions.RideSharingSystem.OverallApproach.model.Ride;

import java.util.List;

public interface IRideRepo {
    String add(Ride ride);
    Ride get(String rideId);
    Ride update(String rideId);
    List<Ride> getAllRides();
}
