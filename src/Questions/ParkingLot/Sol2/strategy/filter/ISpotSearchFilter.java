package Questions.ParkingLot.Sol2.strategy.filter;

import Questions.ParkingLot.Sol2.model.Spot;

import java.util.List;

public interface ISpotSearchFilter {
    List<Spot> getSpots(List<Spot> spots);
}
