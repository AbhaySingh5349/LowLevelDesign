package Questions.RideSharingSystem.SolvedFilterAndSortUsingGenerics.repository;

import Questions.RideSharingSystem.SolvedFilterAndSortUsingGenerics.model.Ride;

import java.util.List;

public interface IRideRepo {
    String create(Ride ride);
    Ride getById(String rideId);
    List<Ride> getAllRides();
}
