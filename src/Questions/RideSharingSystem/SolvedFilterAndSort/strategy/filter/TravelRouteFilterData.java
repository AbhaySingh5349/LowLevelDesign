package Questions.RideSharingSystem.SolvedFilterAndSort.strategy.filter;

import Questions.RideSharingSystem.SolvedFilterAndSort.model.Ride;

import java.util.List;
import java.util.stream.Collectors;

public class TravelRouteFilterData implements IRideFilterData {
    private final String src;
    private final String dst;

    public TravelRouteFilterData(String src, String dst) {
        this.src = src;
        this.dst = dst;
    }

    @Override
    public List<Ride> getFilterData(List<Ride> rides) {
        return rides.stream()
                .filter(ride -> ride.getSrc().equalsIgnoreCase(src) && ride.getDst().equalsIgnoreCase(dst))
                .collect(Collectors.toList());
    }
}
