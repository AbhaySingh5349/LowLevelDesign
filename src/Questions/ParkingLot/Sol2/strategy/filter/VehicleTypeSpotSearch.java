package Questions.ParkingLot.Sol2.strategy.filter;

import Questions.ParkingLot.Sol2.enums.SpotType;
import Questions.ParkingLot.Sol2.model.Spot;

import java.util.List;
import java.util.stream.Collectors;

public class VehicleTypeSpotSearch implements ISpotSearchFilter{
    private final SpotType spotType;

    public VehicleTypeSpotSearch(SpotType spotType) {
        this.spotType = spotType;
    }

    @Override
    public List<Spot> getSpots(List<Spot> spots) {
        return spots.stream().filter(spot -> spot.getSpotType().equals(spotType)).collect(Collectors.toList());
    }
}
