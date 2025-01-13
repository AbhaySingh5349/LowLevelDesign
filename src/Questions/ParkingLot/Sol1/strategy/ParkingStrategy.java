package Questions.ParkingLot.Sol1.strategy;

import Questions.ParkingLot.Sol1.model.ParkingSpot;

import java.util.List;

public interface ParkingStrategy {
    ParkingSpot findSpot(List<ParkingSpot> availableSpots);
}
