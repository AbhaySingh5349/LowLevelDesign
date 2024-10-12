package Questions.RideSharingSystem.SolvedFilterAndSort;

import Questions.RideSharingSystem.SolvedFilterAndSort.dto.SelectRideRequest;
import Questions.RideSharingSystem.SolvedFilterAndSort.enums.RideSortType;
import Questions.RideSharingSystem.SolvedFilterAndSort.enums.VehicleType;
import Questions.RideSharingSystem.SolvedFilterAndSort.model.Ride;
import Questions.RideSharingSystem.SolvedFilterAndSort.model.Vehicle;
import Questions.RideSharingSystem.SolvedFilterAndSort.repository.IRideRepo;
import Questions.RideSharingSystem.SolvedFilterAndSort.repository.InMemoryRideRepo;
import Questions.RideSharingSystem.SolvedFilterAndSort.service.RideService;
import Questions.RideSharingSystem.SolvedFilterAndSort.strategy.filter.IRideFilterData;
import Questions.RideSharingSystem.SolvedFilterAndSort.strategy.filter.RequiredSeatsFilterData;
import Questions.RideSharingSystem.SolvedFilterAndSort.strategy.filter.TravelRouteFilterData;
import Questions.RideSharingSystem.SolvedFilterAndSort.strategy.sort.EarliestStartingSortData;
import Questions.RideSharingSystem.SolvedFilterAndSort.strategy.sort.ISortData;
import Questions.RideSharingSystem.SolvedFilterAndSort.strategy.sort.VehicleTypeSortData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle(VehicleType.SEDAN, "a");
        Vehicle v2 = new Vehicle(VehicleType.SEDAN, "b");
        Vehicle v3 = new Vehicle(VehicleType.HATCH_BACK, "c");
        Vehicle v4 = new Vehicle(VehicleType.SUV, "d");

        Ride r1 = new Ride("a", v1, "A", "B", 30);
        Ride r2 = new Ride("c", v3, "A", "B", 30);
        Ride r3 = new Ride("b", v2, "A", "B", 30);
        Ride r4 = new Ride("d", v4, "A", "B", 30);

        IRideRepo rideRepo = new InMemoryRideRepo();
        rideRepo.create(r1);
        rideRepo.create(r2);
        rideRepo.create(r3);
        rideRepo.create(r4);

        RideService rideService = new RideService(rideRepo);

        List<IRideFilterData> filters = Arrays.asList(
                new RequiredSeatsFilterData(7),            // Filter rides with at least 3 seats
                new TravelRouteFilterData("A", "B")  // Filter rides with src "City A" and dst "City B"
        );

        List<RideSortType> sortingPreferences = Arrays.asList(RideSortType.MOST_VACANT, RideSortType.VEHICLE_TYPE, RideSortType.EARLIEST_STARTING, RideSortType.MIN_COST);
        List<ISortData<?>> sortDataList = new ArrayList<>();
        for (RideSortType preference : sortingPreferences) {
            if (preference == RideSortType.EARLIEST_STARTING) {
                sortDataList.add(new EarliestStartingSortData(new Date()));
            } else if (preference == RideSortType.VEHICLE_TYPE) {
                sortDataList.add(new VehicleTypeSortData(VehicleType.SEDAN));
            } else {
                sortDataList.add(null);  // No additional data needed for MOST_VACANT or MIN_COST
            }
        }

        SelectRideRequest selectRideRequest = new SelectRideRequest("u", filters, sortingPreferences, sortDataList);
        rideService.getPreferredRide(selectRideRequest);
    }
}
