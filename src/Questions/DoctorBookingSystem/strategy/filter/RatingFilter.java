package Questions.DoctorBookingSystem.strategy.filter;

import Questions.DoctorBookingSystem.enums.FilterType;
import Questions.DoctorBookingSystem.enums.UserType;
import Questions.DoctorBookingSystem.model.User;
import Questions.DoctorBookingSystem.strategy.user.DoctorUserProfileDetails;

import java.util.List;
import java.util.stream.Collectors;

public class RatingFilter implements IFilter{
    @Override
    public boolean doesSupport(IFilterDetails filterDetails) {
        return filterDetails.doesSupport(FilterType.AT_LEAST_RATING);
    }

    @Override
    public List<User> support(IFilterDetails filterDetails, List<User> users) {
        RatingFilterDetails ratingFilterDetails = (RatingFilterDetails) filterDetails;
        int points = ratingFilterDetails.getPoints();

        return users.stream()
                .filter(user -> user.getUserType().equals(UserType.DOCTOR) &&
                        user.getUserProfileDetails() instanceof DoctorUserProfileDetails &&
                        ((DoctorUserProfileDetails) user.getUserProfileDetails()).getPoints() >= points)
                .collect(Collectors.toList());
    }
}
