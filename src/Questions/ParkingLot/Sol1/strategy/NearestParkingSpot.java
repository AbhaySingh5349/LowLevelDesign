package Questions.ParkingLot.Sol1.strategy;

import Questions.ParkingLot.Sol1.model.ParkingSpot;

import java.util.List;

public class NearestParkingSpot implements ParkingStrategy{
    @Override
    public ParkingSpot findSpot(List<ParkingSpot> availableSpots) {
        return availableSpots.stream().findFirst().orElse(null);  // Just a simple strategy
    }
}
