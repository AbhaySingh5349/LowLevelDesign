package Questions.RideSharingSystem.SolvedFilterAndSort.repository;

import Questions.RideSharingSystem.SolvedFilterAndSort.model.Ride;

import java.util.List;

public interface IRideRepo {
    String create(Ride ride);
    Ride getById(String rideId);
    List<Ride> getAllRides();
}
