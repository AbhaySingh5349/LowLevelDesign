package Questions.ParkingLot.Sol2.dto;

import Questions.ParkingLot.Sol2.enums.SpotType;
import Questions.ParkingLot.Sol2.strategy.filter.ISpotSearchFilter;
import Questions.ParkingLot.Sol2.strategy.sort.ISpotSortData;

import java.util.List;

public class SpotSearchRequest {
    private final String vehicleId;
    private final List<ISpotSearchFilter> spotSearchFilters;
    private final List<ISpotSortData> spotSortData;

    public SpotSearchRequest(String vehicleId, List<ISpotSearchFilter> spotSearchFilters, List<ISpotSortData> spotSortData) {
        this.vehicleId = vehicleId;
        this.spotSearchFilters = spotSearchFilters;
        this.spotSortData = spotSortData;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public List<ISpotSearchFilter> getSpotSearchFilters() {
        return spotSearchFilters;
    }

    public List<ISpotSortData> getSpotSortData() {
        return spotSortData;
    }
}
