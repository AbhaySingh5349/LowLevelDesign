package Questions.RideSharingSystem.SolvedFilterAndSort.strategy.filter;

import Questions.RideSharingSystem.SolvedFilterAndSort.model.Ride;

import java.util.List;

public interface IRideFilterData {
    List<Ride> getFilterData(List<Ride> rides);
}
