package Questions.RideSharingSystem.strategy;

import Questions.RideSharingSystem.enums.RideSortPreference;
import Questions.RideSharingSystem.model.Ride;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MostVacantRidePreference implements IRideSortStrategy {
    @Override
    public Boolean doesSupport(RideSortPreference ridePreference) {
        return ridePreference.equals(RideSortPreference.MOST_VACANT);
    }

    @Override
    public List<Ride> matchPreference(List<Ride> rides) {
        return rides.stream().sorted(Comparator.comparingInt(Ride::getAvailableSeats).reversed())
                             .collect(Collectors.toList());
    }
}
