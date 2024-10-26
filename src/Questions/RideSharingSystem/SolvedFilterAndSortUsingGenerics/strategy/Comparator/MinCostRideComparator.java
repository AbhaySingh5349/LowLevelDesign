package Questions.RideSharingSystem.SolvedFilterAndSortUsingGenerics.strategy.Comparator;

import Questions.RideSharingSystem.SolvedFilterAndSortUsingGenerics.model.Ride;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingGenerics.enums.VehicleType;

import java.util.Comparator;

public class MinCostRideComparator implements Comparator<Ride> {
    @Override
    public int compare(Ride r1, Ride r2) {
//        return Double.compare(r1.getCost(), r2.getCost());
        return getVehicleRank(r1.getVehicle().getType()) - getVehicleRank(r2.getVehicle().getType());
    }

    private int getVehicleRank(VehicleType vehicleType) {
        return switch (vehicleType) {
            case HATCH_BACK -> 1;
            case SEDAN -> 2;
            case SUV -> 3;
            default -> 4;
        };
    }
}
