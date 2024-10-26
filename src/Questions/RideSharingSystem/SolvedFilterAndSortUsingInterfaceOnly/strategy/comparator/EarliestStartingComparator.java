package Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.strategy.comparator;

import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.model.Ride;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.strategy.sort.EarliestStartingSortData;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.strategy.sort.IRideSortData;

import java.util.Comparator;
import java.util.Date;

public class EarliestStartingComparator implements Comparator<Ride> {
    private final IRideSortData sortData;

    public EarliestStartingComparator(IRideSortData sortData) {
        this.sortData = sortData;
    }

    @Override
    public int compare(Ride r1, Ride r2) {
        if (!(sortData instanceof EarliestStartingSortData)) {
            throw new IllegalArgumentException("Invalid sort data for EarliestStartingRideComparator");
        }

        Date afterDate = ((EarliestStartingSortData) sortData).getAfterDate();

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
