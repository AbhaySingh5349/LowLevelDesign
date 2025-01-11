package Questions.DoctorBookingSystem.strategy.user;

import Questions.DoctorBookingSystem.enums.DoctorType;
import Questions.DoctorBookingSystem.enums.UserType;

public class DoctorUserProfileDetails implements IUserProfileDetails{
    private final DoctorType doctorType;
    private int points;

    public DoctorUserProfileDetails(DoctorType doctorType, int points) {
        this.doctorType = doctorType;
        this.points = points;
    }

    public DoctorType getDoctorType() {
        return doctorType;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points += points;
    }

    @Override
    public String toString() {
        return "DoctorUserProfileDetails{" +
                "doctorType=" + doctorType +
                ", points=" + points +
                '}';
    }
}
