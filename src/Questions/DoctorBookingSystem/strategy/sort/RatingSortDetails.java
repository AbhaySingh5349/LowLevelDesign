package Questions.DoctorBookingSystem.strategy.sort;

import Questions.DoctorBookingSystem.enums.SortType;

public class RatingSortDetails implements ISortDetails{
    @Override
    public boolean doesSupport(SortType sortType) {
        return sortType.equals(SortType.MAX_RATING);
    }
}
