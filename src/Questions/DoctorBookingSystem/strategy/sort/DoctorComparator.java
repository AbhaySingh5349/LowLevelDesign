package Questions.DoctorBookingSystem.strategy.sort;

import Questions.DoctorBookingSystem.enums.DoctorType;
import Questions.DoctorBookingSystem.model.User;
import Questions.DoctorBookingSystem.strategy.user.DoctorUserProfileDetails;

import java.util.Comparator;

public class DoctorComparator implements Comparator<User> {
    DoctorType doctorType;

    public DoctorComparator(DoctorType doctorType) {
        this.doctorType = doctorType;
    }

    @Override
    public int compare(User u1, User u2) {
        DoctorType u1Type = ((DoctorUserProfileDetails) u1.getUserProfileDetails()).getDoctorType();
        DoctorType u2Type = ((DoctorUserProfileDetails) u2.getUserProfileDetails()).getDoctorType();

        int r1 = u1Type.equals(doctorType) ? 1:2;
        int r2 = u2Type.equals(doctorType) ? 1:2;

        return Integer.compare(r1, r2);
    }
}
