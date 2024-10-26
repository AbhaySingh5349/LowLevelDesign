package Questions.RideSharingSystem.SolvedFilterAndSortUsingGenerics.dto;

import Questions.RideSharingSystem.SolvedFilterAndSortUsingGenerics.enums.RideSortType;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingGenerics.strategy.filter.IRideFilterData;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingGenerics.strategy.sort.ISortData;

import java.util.List;

public class SelectRideRequest {
    private final String passengerId;
    private final List<IRideFilterData> rideFilterData;
    private final List<RideSortType> sortingPreferences;
    private final List<ISortData<?>> sortDataList;

    public SelectRideRequest(String passengerId, List<IRideFilterData> rideFilterData, List<RideSortType> sortingPreferences, List<ISortData<?>> sortDataList) {
        this.passengerId = passengerId;
        this.rideFilterData = rideFilterData;
        this.sortingPreferences = sortingPreferences;
        this.sortDataList = sortDataList;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public List<IRideFilterData> getRideFilterData() {
        return rideFilterData;
    }

    public List<RideSortType> getSortingPreferences() {
        return sortingPreferences;
    }

    public List<ISortData<?>> getSortDataList() {
        return sortDataList;
    }
}
