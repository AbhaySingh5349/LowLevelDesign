package Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.strategy.comparator;

import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.enums.VehicleType;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.model.Ride;

import java.util.Comparator;

public class MinCostRideComparator implements Comparator<Ride> {
    @Override
    public int compare(Ride r1, Ride r2) {
        return 0;
    }

    private int getVehicleRank(VehicleType vehicleType){
        return switch (vehicleType){
            case HATCHBACK -> 1;
            case SEDAN -> 2;
            case SUV -> 3;
            default -> 4;
        };
    }
}
