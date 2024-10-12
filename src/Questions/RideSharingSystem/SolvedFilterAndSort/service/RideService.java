package Questions.RideSharingSystem.SolvedFilterAndSort.service;

import Questions.RideSharingSystem.SolvedFilterAndSort.dto.SelectRideRequest;
import Questions.RideSharingSystem.SolvedFilterAndSort.enums.RideSortType;
import Questions.RideSharingSystem.SolvedFilterAndSort.model.Ride;
import Questions.RideSharingSystem.SolvedFilterAndSort.repository.IRideRepo;
import Questions.RideSharingSystem.SolvedFilterAndSort.strategy.Comparator.EarliestStartingRideComparator;
import Questions.RideSharingSystem.SolvedFilterAndSort.strategy.Comparator.MinCostRideComparator;
import Questions.RideSharingSystem.SolvedFilterAndSort.strategy.Comparator.MostVacantRideComparator;
import Questions.RideSharingSystem.SolvedFilterAndSort.strategy.Comparator.VehicleTypeComparator;
import Questions.RideSharingSystem.SolvedFilterAndSort.strategy.filter.IRideFilterData;
import Questions.RideSharingSystem.SolvedFilterAndSort.strategy.sort.ISortData;
import Questions.RideSharingSystem.SolvedFilterAndSort.enums.VehicleType;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class RideService {
    private final IRideRepo rideRepo;

    public RideService(IRideRepo rideRepo) {
        this.rideRepo = rideRepo;
    }

    String create(Ride ride){
        return rideRepo.create(ride);
    }

    Ride getById(String rideId){
        return rideRepo.getById(rideId);
    }

    List<Ride> getAllRides(){
        return rideRepo.getAllRides();
    }

    public Ride getPreferredRide(SelectRideRequest rideRequest){
        List<Ride> rides = rideRepo.getAllRides();

        System.out.println("All rides");
        rides.forEach(System.out::println);

        // filtering
        List<IRideFilterData> filters = rideRequest.getRideFilterData();
        List<Ride> filteredRides = filters.stream()
                .reduce(rides,
                        (filtered, filter) -> filter.getFilterData(filtered),
                        (a, b) -> b);

        System.out.println("Filtered rides based on preferences:");
        filteredRides.forEach(System.out::println);

        List<RideSortType> sortingPreferences = rideRequest.getSortingPreferences();
        List<ISortData<?>> sortDataList = rideRequest.getSortDataList();

        filteredRides.sort((r1, r2) -> {
            for (int i = 0; i < sortingPreferences.size(); i++) {
                RideSortType sortType = sortingPreferences.get(i);
                Comparator<Ride> comparator = getComparatorForSortType(sortType, sortDataList.get(i));
                int comparisonResult = comparator.compare(r1, r2);
                if (comparisonResult != 0) {
                    return comparisonResult;
                }
            }
            return 0;  // All comparisons resulted in a tie
        });

        System.out.println("Sorted rides based on preferences:");
        filteredRides.forEach(System.out::println);

        Ride preferredRide = !filteredRides.isEmpty() ? filteredRides.get(0) : null;

        return preferredRide;
    }

    private static Comparator<Ride> getComparatorForSortType(RideSortType sortType, ISortData<?> sortData) {
        switch (sortType) {
            case MOST_VACANT:
                return new MostVacantRideComparator();
            case EARLIEST_STARTING:
                return new EarliestStartingRideComparator((ISortData<Date>) sortData);
            case MIN_COST:
                return new MinCostRideComparator();
            case VEHICLE_TYPE:
                return new VehicleTypeComparator((ISortData<VehicleType>) sortData);
            default:
                throw new IllegalArgumentException("Unknown sort type: " + sortType);
        }
    }
}
