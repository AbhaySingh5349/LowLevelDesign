package Questions.ParkingLot.Sol2.strategy.sort;

import Questions.ParkingLot.Sol2.enums.SpotType;
import Questions.ParkingLot.Sol2.model.Spot;

import java.util.Comparator;

public class PreferredSpotTypeComparator implements Comparator<Spot> {
    private final ISpotSortData sortData;

    public PreferredSpotTypeComparator(ISpotSortData sortData) {
        this.sortData = sortData;
    }

    @Override
    public int compare(Spot o1, Spot o2) {
        if(!(sortData instanceof PreferredSpotTypeSortData)){
            throw new IllegalArgumentException("Invalid sort data for PreferredSpotTypeComparator");
        }

        PreferredSpotTypeSortData preferredSpotTypeSortData = (PreferredSpotTypeSortData) sortData;
        SpotType preferredSpot = preferredSpotTypeSortData.getSpotType();

        int p1 = getSpotPriority(o1.getSpotType(), preferredSpot);
        int p2 = getSpotPriority(o2.getSpotType(), preferredSpot);

        return Integer.compare(p1, p2);
    }

    private int getSpotPriority(SpotType spotType, SpotType preferredSpotType){
        return spotType.equals(preferredSpotType) ? 1:2;
    }
}
