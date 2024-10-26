package Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.repository;

import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.model.Ride;

import java.util.List;

public interface IRideRepo {
    void add(Ride ride);
    Ride getById(String id);
    List<Ride> getAllRides();
}
