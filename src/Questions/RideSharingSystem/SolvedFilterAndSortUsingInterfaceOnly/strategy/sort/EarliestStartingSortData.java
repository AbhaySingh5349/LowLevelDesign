package Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.strategy.sort;

import java.util.Date;

public class EarliestStartingSortData implements IRideSortData {
    private final Date afterDate;

    public EarliestStartingSortData(Date afterDate) {
        this.afterDate = afterDate;
    }

    public Date getAfterDate() {
        return afterDate;
    }
}
