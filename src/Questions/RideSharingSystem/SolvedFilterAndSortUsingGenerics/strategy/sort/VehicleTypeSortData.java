package Questions.RideSharingSystem.SolvedFilterAndSortUsingGenerics.strategy.sort;

import Questions.RideSharingSystem.SolvedFilterAndSortUsingGenerics.enums.VehicleType;

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
