package Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.service;

import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.dto.SelectRideRequest;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.enums.RideSortType;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.model.Ride;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.repository.IRideRepo;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.strategy.comparator.EarliestStartingComparator;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.strategy.comparator.MinCostRideComparator;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.strategy.comparator.MostVacantRideComparator;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.strategy.comparator.VehicleTypeComparator;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.strategy.filter.IRideFilterData;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.strategy.sort.IRideSortData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RideService {
    private final IRideRepo rideRepo;

    public RideService(IRideRepo rideRepo) {
        this.rideRepo = rideRepo;
    }

    public void create(Ride ride){
        rideRepo.add(ride);
    }

    public Ride getRideById(String id){
        return rideRepo.getById(id);
    }

    public Ride getPreferredRide(SelectRideRequest request){
        List<Ride> rides = rideRepo.getAllRides();

        System.out.println("All rides");
        rides.forEach(System.out::println);

        // filtering
        List<IRideFilterData> filters = request.getRideFilterData();

        /*
        List<Ride> filteredRides = new ArrayList<>(rides);
        // Apply each filter sequentially
        for (IRideFilterData filter : filters) {
            filteredRides = filter.getFilteredRides(filteredRides);
        }
        */

        List<Ride> filteredRides = filters.stream()
                .reduce(rides,
                        (intermediateFilteredRides, filter) -> filter.getFilteredRides(intermediateFilteredRides),
                        (a, b) -> b);

        System.out.println("Filtered rides based on preferences:");
        filteredRides.forEach(System.out::println);

        List<RideSortType> sortPreferences = request.getSortingPreferences();
        List<IRideSortData> sortDataList = request.getRideSortData();

        filteredRides.sort((r1, r2) -> {
            for(int i=0;i<sortPreferences.size();i++){
                RideSortType sortType = sortPreferences.get(i);
                IRideSortData sortData = sortDataList.get(i);

                Comparator<Ride> comparator = getComparatorForSortType(sortType, sortData);

                int comparisonResult = comparator.compare(r1, r2);
                if (comparisonResult != 0) {
                    return comparisonResult;
                }
            }
            return 0;  // All comparisons resulted in a tie
        });

        System.out.println("Sorted rides based on preferences:");
        filteredRides.forEach(System.out::println);

        return !filteredRides.isEmpty() ? filteredRides.get(0) : null;
    }

    private static Comparator<Ride> getComparatorForSortType(RideSortType sortType, IRideSortData sortData){
        return switch (sortType){
            case MOST_VACANT -> new MostVacantRideComparator();
            case EARLIEST_STARTING -> new EarliestStartingComparator(sortData);
            case MIN_COST -> new MinCostRideComparator();
            case VEHICLE_TYPE -> new VehicleTypeComparator(sortData);
//            default -> throw new IllegalArgumentException("Unknown sort type: " + sortType);
        };
    }
}
