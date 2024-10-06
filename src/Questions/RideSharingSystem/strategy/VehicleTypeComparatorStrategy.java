package Questions.RideSharingSystem.strategy;

import Questions.RideSharingSystem.dto.ISortData;
import Questions.RideSharingSystem.enums.VehicleType;
import Questions.RideSharingSystem.model.Ride;

public class VehicleTypeComparatorStrategy implements IRideSortComparatorStrategy<VehicleType> {
    @Override
    public int compare(Ride r1, Ride r2, ISortData<VehicleType> sortData) {
        VehicleType preferredVehicleType = sortData.getSortData();
        VehicleType v1 = r1.getVehicle().getVehicleType();
        VehicleType v2 = r2.getVehicle().getVehicleType();

        if(v1.equals(preferredVehicleType)) return -1;
        if(v2.equals(preferredVehicleType)) return 1;
        return 0;
    }
}
