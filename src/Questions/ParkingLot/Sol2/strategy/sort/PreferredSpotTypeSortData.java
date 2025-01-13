package Questions.ParkingLot.Sol2.strategy.sort;

import Questions.ParkingLot.Sol2.enums.SpotSortType;
import Questions.ParkingLot.Sol2.enums.SpotType;

public class PreferredSpotTypeSortData implements ISpotSortData{
    private final SpotType spotType;

    public PreferredSpotTypeSortData(SpotType spotType) {
        this.spotType = spotType;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    @Override
    public SpotSortType getSortType() {
        return SpotSortType.PREFERRED_SPOT_TYPE;
    }
}
