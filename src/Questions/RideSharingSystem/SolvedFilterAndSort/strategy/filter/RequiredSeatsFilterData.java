package Questions.RideSharingSystem.SolvedFilterAndSort.strategy.filter;

import Questions.RideSharingSystem.SolvedFilterAndSort.model.Ride;

import java.util.List;
import java.util.stream.Collectors;

public class RequiredSeatsFilterData implements IRideFilterData {
    private final int minRequiredSeats;

    public RequiredSeatsFilterData(int minRequiredSeats) {
        this.minRequiredSeats = minRequiredSeats;
    }

    @Override
    public List<Ride> getFilterData(List<Ride> rides) {
        return rides.stream().filter(ride -> ride.getAvailableSeats() >= minRequiredSeats).collect(Collectors.toList());
    }
}
