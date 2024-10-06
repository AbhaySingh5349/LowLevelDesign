package Questions.RideSharingSystem.repository;

import Questions.RideSharingSystem.model.Ride;

import java.util.*;

public class InMemoryRideRepo implements IRideRepo{
    Map<String, Ride> rideMap;

    @Override
    public String add(Ride ride) {
        String id = UUID.randomUUID().toString();
        rideMap.put(id, ride);

        return id;
    }

    @Override
    public Ride get(String rideId) {
        return rideMap.get(rideId);
    }

    @Override
    public Ride update(String rideId) {
        return null;
    }

    @Override
    public List<Ride> getAllRides() {
        return new ArrayList<>(rideMap.values());
    }
}
