package Questions.RideSharingSystem.strategy;

import Questions.RideSharingSystem.dto.ISortData;
import Questions.RideSharingSystem.model.Ride;

public class MostVacantComparatorStrategy implements IRideSortComparatorStrategy<Integer> {
    @Override
    public int compare(Ride r1, Ride r2, ISortData<Integer> sortData) {
        Integer requiredSeats = sortData.getSortData();
        int s1 = r1.getAvailableSeats();
        int s2 = r2.getAvailableSeats();

        if(s1 > s2){
            return s1 > requiredSeats ? -1:0;
        }else if(s2 > s1){
            return s2 > requiredSeats ? 1:0;
        }
        return 0;
    }
}
