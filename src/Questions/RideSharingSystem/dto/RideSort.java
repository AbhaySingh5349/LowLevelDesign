package Questions.RideSharingSystem.dto;

import Questions.RideSharingSystem.enums.RideSortPreference;

public class RideSort<T>{
    private final RideSortPreference rideSortPreference;
    private final ISortData<T> sortData;

    public RideSort(RideSortPreference rideSortPreference, ISortData<T> sortData) {
        this.rideSortPreference = rideSortPreference;
        this.sortData = sortData;
    }

    public RideSortPreference getRideSortPreference() {
        return rideSortPreference;
    }

    public ISortData<T> getSortData() {
        return sortData;
    }
}
