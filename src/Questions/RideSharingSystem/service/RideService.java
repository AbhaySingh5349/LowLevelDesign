package Questions.RideSharingSystem.service;

import Questions.RideSharingSystem.dto.RideSort;
import Questions.RideSharingSystem.dto.SelectRideRequest;
import Questions.RideSharingSystem.enums.RideSortPreference;
import Questions.RideSharingSystem.model.Ride;
import Questions.RideSharingSystem.repository.IRideRepo;
import Questions.RideSharingSystem.strategy.IRideSortComparatorStrategy;
import Questions.RideSharingSystem.strategy.IRideSortStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class RideService {
    private final IRideRepo rideRepo;
    private final List<IRideSortStrategy> preferenceStrategies;
    private final Map<RideSortPreference, IRideSortComparatorStrategy> ridePreferenceComparatorStrategyMap;
    private final BookingService bookingService;

    public RideService(IRideRepo rideRepo, List<IRideSortStrategy> preferenceStrategies, Map<RideSortPreference, IRideSortComparatorStrategy> ridePreferenceComparatorStrategyMap, BookingService bookingService) {
        this.rideRepo = rideRepo;
        this.preferenceStrategies = preferenceStrategies;
        this.ridePreferenceComparatorStrategyMap = ridePreferenceComparatorStrategyMap;
        this.bookingService = bookingService;
    }

    public String createRide(Ride ride){
        return rideRepo.add(ride);
    }

    public Ride getRide(String rideId){
        return rideRepo.get(rideId);
    }

    public String bookRide(SelectRideRequest request){
        // option 1: get all rides from DB and then do filtering & sorting (lower performance as we need to fetch all data from DB)
        // option 2: list of rides matching src & dst and then do sorting on preference

        List<Ride> rides = rideRepo.getAllRides();


//        Problem with current filtering strategy is, we are restricting code for 2 types of filters only.
//        So we need Filter class separately to handle key-value pair associated to each RideFilterName enum.
//        Also, data or value corresponding to each filter name will be different, so we maintain interface for it
        /*
        List<Ride> filteredRides = rides.stream()
                .filter(ride -> ride.hasPath(request.getStartLocation(), request.getEndLocation()))
                .filter(ride -> ride.getAvailableSeats() > request.getRequiredSeats())
                .collect(Collectors.toList());

        // have strategy defined and apply on filtered rides: strategy.apply(request.getRidePreference())

        RidePreference userPreference = request.getRidePreference();

        for(IRidePreferenceStrategy strategy : preferenceStrategies){
            if(strategy.doesSupport(userPreference)){
                filteredRides = strategy.matchPreference(filteredRides);
            }
        }

        Ride ride = !filteredRides.isEmpty() ? filteredRides.get(0) : null;

        if(ride != null){
            String bookingId = bookingService.createBooking(ride, request.getUser(), request.getRequiredSeats(), request.getStartLocation(), request.getEndLocation());
            Booking booking = bookingService.getBooking(bookingId);

            ride.getBookings().add(booking);
            ride.setAvailableSeats(-request.getRequiredSeats());

            return bookingId;
        }
         */

        // filtering rides based on user filter strategies
        List<Ride> filteredRides = new ArrayList<>();

        // Incorrect way of sorting filtered rides based on user preferences
        // since sorting is happening independently
        /*
        List<RidePreference> ridePreferences = request.getRidePreferences();
        for(RidePreference preference : ridePreferences){
            for(IRidePreferenceStrategy strategy : preferenceStrategies){
                if(strategy.doesSupport(preference)){
                    filteredRides = strategy.matchPreference(filteredRides); // sorting rides based on strategy
                }
            }
        }
         */

        List<RideSort> rideSortPreferences = request.getRidePreferences();
        Collections.sort(filteredRides, (r1, r2) -> {
            for(RideSort rideSort : rideSortPreferences){
                final IRideSortComparatorStrategy comparatorStrategy = ridePreferenceComparatorStrategyMap.get(rideSort.getRideSortPreference());

                int compare = comparatorStrategy.compare(r1, r2, rideSort.getSortData());
                if(compare != 0){
                    return compare;
                }
            }
            return 0;
        });

        Ride ride = !filteredRides.isEmpty() ? filteredRides.get(0) : null;

        // create booking

        return null;
    }
}
