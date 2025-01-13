package Questions.ParkingLot.Sol2.strategy.filter;

import Questions.ParkingLot.Sol2.enums.SpotStatus;
import Questions.ParkingLot.Sol2.model.Spot;

import java.util.List;
import java.util.stream.Collectors;

public class SpotStatusSearch implements ISpotSearchFilter{
    private final SpotStatus spotStatus;

    public SpotStatusSearch(SpotStatus spotStatus) {
        this.spotStatus = spotStatus;
    }

    @Override
    public List<Spot> getSpots(List<Spot> spots) {
        return spots.stream().filter(spot -> spot.getSpotStatus().equals(spotStatus)).collect(Collectors.toList());
    }
}
