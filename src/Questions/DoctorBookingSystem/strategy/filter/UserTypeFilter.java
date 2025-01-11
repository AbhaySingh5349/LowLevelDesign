package Questions.DoctorBookingSystem.strategy.filter;

import Questions.DoctorBookingSystem.enums.FilterType;
import Questions.DoctorBookingSystem.enums.UserType;
import Questions.DoctorBookingSystem.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserTypeFilter implements IFilter{
    @Override
    public boolean doesSupport(IFilterDetails filterDetails) {
        return filterDetails.doesSupport(FilterType.DOCTOR_OR_PATIENT);
    }

    @Override
    public List<User> support(IFilterDetails filterDetails, List<User> users) {
        UserTypeFilterDetails userTypeFilterDetails = (UserTypeFilterDetails) filterDetails;
        UserType userType = userTypeFilterDetails.getUserType();

        return users.stream().filter(user -> user.getUserType().equals(userType)).collect(Collectors.toList());
    }
}
