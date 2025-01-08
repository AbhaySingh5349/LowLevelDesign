package Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.strategy.filter;

import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.model.Ride;

import java.util.List;
import java.util.stream.Collectors;

public class TravelRouteFilterData implements IRideFilterData{
    private final String src;
    private final String dst;

    public TravelRouteFilterData(String src, String dst) {
        this.src = src;
        this.dst = dst;
    }

    @Override
    public List<Ride> getFilteredRides(List<Ride> rides) {
        return rides.stream().filter(ride -> ride.getSrc().equals(src) && ride.getDst().equals(dst)).collect(Collectors.toList());
    }
}
