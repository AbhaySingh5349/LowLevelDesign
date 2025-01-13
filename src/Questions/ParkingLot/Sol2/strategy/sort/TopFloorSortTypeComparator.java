package Questions.ParkingLot.Sol2.strategy.sort;

import Questions.ParkingLot.Sol2.model.Spot;

import java.util.Comparator;

public class TopFloorSortTypeComparator implements Comparator<Spot> {
    @Override
    public int compare(Spot o1, Spot o2) {
        return Integer.compare(o2.getFloorNum(), o1.getFloorNum());
    }
}
