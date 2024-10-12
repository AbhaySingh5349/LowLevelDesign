package Questions.RideSharingSystem.SolvedFilterAndSort.strategy.Comparator;

import Questions.RideSharingSystem.SolvedFilterAndSort.model.Ride;
import Questions.RideSharingSystem.SolvedFilterAndSort.strategy.sort.ISortData;

import java.util.Comparator;
import java.util.Date;

public class EarliestStartingRideComparator implements Comparator<Ride> {
    private final Date afterDate;

    public EarliestStartingRideComparator(ISortData<Date> afterDate) {
        this.afterDate = afterDate.getData();
    }

    @Override
    public int compare(Ride r1, Ride r2) {
        if (r1.getStartTime().after(afterDate) && r2.getStartTime().after(afterDate)) {
            return r1.getStartTime().compareTo(r2.getStartTime()); // Ascending order
        } else if (r1.getStartTime().after(afterDate)) {
            return -1;
        } else if (r2.getStartTime().after(afterDate)) {
            return 1;
        } else {
            return 0;
        }
    }
}
