package Questions.RideSharingSystem.OverallApproach.strategy;

import Questions.RideSharingSystem.OverallApproach.dto.ISortData;
import Questions.RideSharingSystem.OverallApproach.model.Ride;

public interface IRideSortComparatorStrategy<T> {
    int compare(Ride r1, Ride r2, ISortData<T> sortData);
}
