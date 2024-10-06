package Questions.RideSharingSystem.dto;

import Questions.RideSharingSystem.enums.RideFilterName;

public class RideFilter {
    private final RideFilterName filterName;
    private final IFilterData data;

    public RideFilter(RideFilterName filterName, IFilterData data) {
        this.filterName = filterName;
        this.data = data;
    }

    public RideFilterName getFilterName() {
        return filterName;
    }

    public IFilterData getData() {
        return data;
    }
}