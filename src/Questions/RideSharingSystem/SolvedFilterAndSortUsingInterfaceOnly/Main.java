package Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly;

import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.dto.SelectRideRequest;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.enums.RideSortType;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.enums.VehicleType;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.model.Ride;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.model.Vehicle;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.repository.IRideRepo;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.repository.InMemoryRideRepo;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.service.RideService;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.strategy.filter.IRideFilterData;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.strategy.filter.RequiredSeatsFilterData;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.strategy.filter.TravelRouteFilterData;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.strategy.sort.EarliestStartingSortData;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.strategy.sort.IRideSortData;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.strategy.sort.VehicleTypeSortData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("1", "a", VehicleType.SEDAN);
        Vehicle v2 = new Vehicle("2", "b", VehicleType.SEDAN);
        Vehicle v3 = new Vehicle("3", "c", VehicleType.HATCHBACK);
        Vehicle v4 = new Vehicle("4", "d", VehicleType.SUV);

        Ride r1 = new Ride("1", "a", v1, "A", "B", 30);
        Ride r2 = new Ride("3", "c", v3, "A", "B", 30);
        Ride r3 = new Ride("2", "b", v2, "A", "B", 30);
        Ride r4 = new Ride("4", "d", v4, "A", "B", 30);

        IRideRepo rideRepo = new InMemoryRideRepo();
        rideRepo.add(r1);
        rideRepo.add(r2);
        rideRepo.add(r3);
        rideRepo.add(r4);

        RideService rideService = new RideService(rideRepo);

        List<IRideFilterData> filters = Arrays.asList(
                new RequiredSeatsFilterData(3),            // Filter rides with at least 3 seats
                new TravelRouteFilterData("A", "B")  // Filter rides with src "City A" and dst "City B"
        );

        List<RideSortType> sortingPreferences = Arrays.asList(RideSortType.MOST_VACANT, RideSortType.VEHICLE_TYPE, RideSortType.EARLIEST_STARTING, RideSortType.MIN_COST);
        List<IRideSortData> sortDataList = new ArrayList<>();
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