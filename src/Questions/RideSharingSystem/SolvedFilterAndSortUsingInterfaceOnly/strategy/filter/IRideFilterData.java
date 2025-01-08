package Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.strategy.filter;

import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.model.Ride;

import java.util.List;

public interface IRideFilterData {
    List<Ride> getFilteredRides(List<Ride> rides);
}
