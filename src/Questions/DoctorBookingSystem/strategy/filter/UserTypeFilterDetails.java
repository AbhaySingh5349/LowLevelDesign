package Questions.DoctorBookingSystem.strategy.filter;

import Questions.DoctorBookingSystem.enums.FilterType;
import Questions.DoctorBookingSystem.enums.UserType;

public class UserTypeFilterDetails implements IFilterDetails{
    private final UserType userType;

    public UserTypeFilterDetails(UserType userType) {
        this.userType = userType;
    }

    public UserType getUserType() {
        return userType;
    }

    @Override
    public boolean doesSupport(FilterType filterType) {
        return filterType.equals(FilterType.DOCTOR_OR_PATIENT);
    }
}
