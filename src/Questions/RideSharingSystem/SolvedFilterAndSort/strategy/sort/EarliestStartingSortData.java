package Questions.RideSharingSystem.SolvedFilterAndSort.strategy.sort;

import java.util.Date;

public class EarliestStartingSortData implements ISortData<Date> {
    private final Date afterDate;

    public EarliestStartingSortData(Date afterDate) {
        this.afterDate = afterDate;
    }

    @Override
    public Date getData() {
        return afterDate;
    }
}
