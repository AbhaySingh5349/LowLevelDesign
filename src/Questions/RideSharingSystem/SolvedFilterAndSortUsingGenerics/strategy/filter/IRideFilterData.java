package Questions.RideSharingSystem.SolvedFilterAndSortUsingGenerics.strategy.filter;

import Questions.RideSharingSystem.SolvedFilterAndSortUsingGenerics.model.Ride;

import java.util.List;

public interface IRideFilterData {
    List<Ride> getFilterData(List<Ride> rides);
}
