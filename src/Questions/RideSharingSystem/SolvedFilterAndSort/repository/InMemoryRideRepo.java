package Questions.RideSharingSystem.SolvedFilterAndSort.repository;

import Questions.RideSharingSystem.SolvedFilterAndSort.model.Ride;

import java.util.*;

public class InMemoryRideRepo implements IRideRepo{
    Map<String, Ride> rideMap;

    public InMemoryRideRepo() {
        this.rideMap = new HashMap<>();
    }

    @Override
    public String create(Ride ride) {
        String  id = UUID.randomUUID().toString();
        ride.setId(id);
        rideMap.put(id, ride);
        return id;
    }

    @Override
    public Ride getById(String rideId) {
        return rideMap.get(rideId);
    }

    @Override
    public List<Ride> getAllRides() {
        return new ArrayList<>(rideMap.values());
    }
}
