package Questions.ParkingLot.strategy;

import Questions.ParkingLot.model.ParkingSpot;

import java.util.List;

public interface ParkingStrategy {
    ParkingSpot findSpot(List<ParkingSpot> availableSpots);
}
