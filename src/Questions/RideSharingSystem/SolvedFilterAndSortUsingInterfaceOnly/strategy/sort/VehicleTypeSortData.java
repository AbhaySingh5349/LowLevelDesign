package Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.strategy.sort;

import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.enums.VehicleType;

public class VehicleTypeSortData implements IRideSortData {
    private final VehicleType preferredType;

    public VehicleTypeSortData(VehicleType preferredType) {
        this.preferredType = preferredType;
    }

    public VehicleType getPreferredType() {
        return preferredType;
    }
}
