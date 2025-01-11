package Questions.DoctorBookingSystem.strategy.filter;

import Questions.DoctorBookingSystem.enums.FilterType;
import Questions.DoctorBookingSystem.model.User;

import java.util.List;

public class RatingFilterDetails implements IFilterDetails{
    private final int points;

    public RatingFilterDetails(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public boolean doesSupport(FilterType filterType) {
        return filterType.equals(FilterType.AT_LEAST_RATING);
    }
}
