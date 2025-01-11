package Questions.DoctorBookingSystem.model;

import Questions.DoctorBookingSystem.enums.UserType;
import Questions.DoctorBookingSystem.strategy.actions.IActionDetails;
import Questions.DoctorBookingSystem.strategy.user.IUserProfileDetails;

import java.util.List;

public class User {
    private final String id;
    private UserType userType;
    private IUserProfileDetails userProfileDetails;
    private List<IActionDetails> actionDetailsList;

    public User(String id, UserType userType, IUserProfileDetails userProfileDetails) {
        this.id = id;
        this.userType = userType;
        this.userProfileDetails = userProfileDetails;
    }

    public String getId() {
        return id;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public IUserProfileDetails getUserProfileDetails() {
        return userProfileDetails;
    }

    public void setUserProfileDetails(IUserProfileDetails userProfileDetails) {
        this.userProfileDetails = userProfileDetails;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userType=" + userType +
                ", userProfileDetails=" + userProfileDetails +
                '}';
    }
}
