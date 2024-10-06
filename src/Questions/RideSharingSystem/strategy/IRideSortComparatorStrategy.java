package Questions.RideSharingSystem.strategy;

import Questions.RideSharingSystem.dto.ISortData;
import Questions.RideSharingSystem.model.Ride;

public interface IRideSortComparatorStrategy<T> {
    int compare(Ride r1, Ride r2, ISortData<T> sortData);
}
