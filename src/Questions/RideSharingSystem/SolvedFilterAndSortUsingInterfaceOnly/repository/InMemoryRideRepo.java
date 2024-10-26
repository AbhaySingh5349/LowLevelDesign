package Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.repository;

import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.model.Ride;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRideRepo implements IRideRepo{
    private final Map<String, Ride> rideMap;

    public InMemoryRideRepo() {
        this.rideMap = new HashMap<>();
    }

    @Override
    public void add(Ride ride) {
        String id = ride.getId();
        rideMap.put(id, ride);
    }

    @Override
    public Ride getById(String id) {
        return rideMap.get(id);
    }

    @Override
    public List<Ride> getAllRides() {
        return new ArrayList<>(rideMap.values());
    }
}
