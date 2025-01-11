package Questions.DoctorBookingSystem.strategy.sort;

import Questions.DoctorBookingSystem.enums.SortType;
import Questions.DoctorBookingSystem.model.User;

public class RatingSort implements ISort{
    @Override
    public boolean doesSupport(ISortDetails sortDetails) {
        return sortDetails.doesSupport(SortType.MAX_RATING);
    }

    @Override
    public int support(ISortDetails sortDetails, User u1, User u2) {
        RatingComparator ratingComparator = new RatingComparator();

        return ratingComparator.compare(u1, u2);
    }
}
