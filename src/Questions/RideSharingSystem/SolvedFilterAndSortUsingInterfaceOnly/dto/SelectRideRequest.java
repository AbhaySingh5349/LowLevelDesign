package Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.dto;

import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.enums.RideSortType;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.strategy.filter.IRideFilterData;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.strategy.sort.IRideSortData;

import java.util.List;

public class SelectRideRequest {
    private final String passengerId;
    private final List<IRideFilterData> rideFilterData;
    private final List<RideSortType> sortingPreferences;
    private final List<IRideSortData> rideSortData;

    public SelectRideRequest(String passengerId, List<IRideFilterData> rideFilterData, List<RideSortType> sortingPreferences, List<IRideSortData> rideSortData) {
        this.passengerId = passengerId;
        this.rideFilterData = rideFilterData;
        this.sortingPreferences = sortingPreferences;
        this.rideSortData = rideSortData;
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

    public List<IRideSortData> getRideSortData() {
        return rideSortData;
    }
}
