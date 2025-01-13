package Questions.ParkingLot.Sol2.strategy.filter;

import Questions.ParkingLot.Sol2.model.Spot;

import java.util.List;
import java.util.stream.Collectors;

public class MinFloorNumSpotSearch implements ISpotSearchFilter{
    private final int minFloorNum;

    public MinFloorNumSpotSearch(int minFloorNum) {
        this.minFloorNum = minFloorNum;
    }

    public int getMinFloorNum() {
        return minFloorNum;
    }

    @Override
    public List<Spot> getSpots(List<Spot> spots) {
        return spots.stream().filter(spot -> spot.getFloorNum() >= minFloorNum).collect(Collectors.toList());
    }
}
