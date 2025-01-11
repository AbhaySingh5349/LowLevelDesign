package Questions.DoctorBookingSystem.strategy.sort;


import Questions.DoctorBookingSystem.model.User;
import Questions.DoctorBookingSystem.strategy.user.DoctorUserProfileDetails;

import java.util.Comparator;

public class RatingComparator implements Comparator<User> {
    @Override
    public int compare(User u1, User u2) {
        int r1 = ((DoctorUserProfileDetails) u1.getUserProfileDetails()).getPoints();
        int r2 = ((DoctorUserProfileDetails) u2.getUserProfileDetails()).getPoints();

        return Integer.compare(r2, r1);
    }
}
