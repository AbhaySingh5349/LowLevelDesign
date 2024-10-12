package Questions.RideSharingSystem.SolvedFilterAndSort.strategy.sort;

import Questions.RideSharingSystem.SolvedFilterAndSort.enums.VehicleType;

public class VehicleTypeSortData implements ISortData<VehicleType>{
    private final VehicleType preferredVehicleType;

    public VehicleTypeSortData(VehicleType preferredVehicleType) {
        this.preferredVehicleType = preferredVehicleType;
    }

    @Override
    public VehicleType getData() {
        return preferredVehicleType;
    }
}
