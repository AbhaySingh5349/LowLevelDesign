package Questions.ParkingLot.repository;

import Questions.ParkingLot.model.ParkingSpot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParkingSpotRepository {
    private final Map<String, ParkingSpot> parkingSpots = new HashMap<>();

    public ParkingSpot getSpotById(String spotId) {
        return parkingSpots.get(spotId);
    }

    public void addSpot(ParkingSpot spot) {
        parkingSpots.put(spot.getSpotId(), spot);
    }

    public void updateSpot(ParkingSpot spot) {
        parkingSpots.put(spot.getSpotId(), spot);
    }

    public List<ParkingSpot> getAvailableSpots(){
        return parkingSpots.values().stream()
                .filter(spot -> spot.isAvailable())
                .collect(Collectors.toList());
    }
}
