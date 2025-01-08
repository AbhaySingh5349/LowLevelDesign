package Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.strategy.comparator;

import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.enums.VehicleType;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.model.Ride;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.strategy.sort.IRideSortData;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.strategy.sort.VehicleTypeSortData;

import java.util.Comparator;

public class VehicleTypeComparator implements Comparator<Ride> {
    private final IRideSortData sortData;

    public VehicleTypeComparator(IRideSortData sortData) {
        this.sortData = sortData;
    }

    @Override
    public int compare(Ride r1, Ride r2) {
        if(!(sortData instanceof VehicleTypeSortData)){
            throw new IllegalArgumentException("Invalid sort data for VehicleTypeComparator");
        }

        VehicleType preferredVehicleType = ((VehicleTypeSortData) sortData).getPreferredType();

        int r1Priority = getVehiclePriority(r1.getVehicle().getType(), preferredVehicleType);
        int r2Priority = getVehiclePriority(r2.getVehicle().getType(), preferredVehicleType);

        return Integer.compare(r1Priority, r2Priority); // ascending order
    }

    private int getVehiclePriority(VehicleType vehicleType, VehicleType preferredVehicleType){
        // Highest priority for the preferred type
        return vehicleType.equals(preferredVehicleType) ? 1:2;
    }
}
