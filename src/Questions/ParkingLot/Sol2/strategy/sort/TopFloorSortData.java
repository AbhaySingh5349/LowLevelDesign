package Questions.ParkingLot.Sol2.strategy.sort;

import Questions.ParkingLot.Sol2.enums.SpotSortType;

public class TopFloorSortData implements ISpotSortData{
    @Override
    public SpotSortType getSortType() {
        return SpotSortType.TOP_FLOOR;
    }
}
