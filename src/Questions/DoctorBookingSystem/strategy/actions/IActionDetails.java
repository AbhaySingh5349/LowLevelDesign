package Questions.DoctorBookingSystem.strategy.actions;

import Questions.DoctorBookingSystem.enums.UserType;

public interface IActionDetails {
    boolean doesSupport(UserType userType);
}
