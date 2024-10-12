package Questions.RideSharingSystem.OverallApproach.dto;

import Questions.RideSharingSystem.OverallApproach.enums.VehicleType;

public class VehicleTypeSortData implements ISortData<VehicleType>{
    private final VehicleType vehicleType;

    public VehicleTypeSortData(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public VehicleType getSortData() {
        return vehicleType;
    }
}
