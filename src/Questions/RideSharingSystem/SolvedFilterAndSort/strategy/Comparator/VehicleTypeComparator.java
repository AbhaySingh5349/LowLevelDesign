package Questions.RideSharingSystem.SolvedFilterAndSort.strategy.Comparator;

import Questions.RideSharingSystem.SolvedFilterAndSort.model.Ride;
import Questions.RideSharingSystem.SolvedFilterAndSort.strategy.sort.ISortData;
import Questions.RideSharingSystem.SolvedFilterAndSort.enums.VehicleType;

import java.util.Comparator;

public class VehicleTypeComparator implements Comparator<Ride> {
    private final VehicleType preferredVehicleType;

    public VehicleTypeComparator(ISortData<VehicleType> preferredVehicleType) {
        this.preferredVehicleType = preferredVehicleType.getData();
    }

    @Override
    public int compare(Ride r1, Ride r2) {
        // Prioritize rides matching the preferred vehicle type
        int r1Priority = getVehiclePriority(r1.getVehicle().getType());
        int r2Priority = getVehiclePriority(r2.getVehicle().getType());
        return Integer.compare(r1Priority, r2Priority);
    }

    private int getVehiclePriority(VehicleType vehicleType) {
        if (vehicleType.equals(preferredVehicleType)) {
            return 1; // Highest priority for the preferred type
        } else {
            return 2; // Lower priority for non-preferred types
        }
    }
}
