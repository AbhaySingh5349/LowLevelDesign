package Questions.DoctorBookingSystem.strategy.filter;

import Questions.DoctorBookingSystem.enums.DoctorType;
import Questions.DoctorBookingSystem.enums.FilterType;
import Questions.DoctorBookingSystem.enums.UserType;
import Questions.DoctorBookingSystem.model.User;
import Questions.DoctorBookingSystem.strategy.user.DoctorUserProfileDetails;

import java.util.List;
import java.util.stream.Collectors;

public class DoctorTypeFilter implements IFilter{
    @Override
    public boolean doesSupport(IFilterDetails filterDetails) {
        return filterDetails.doesSupport(FilterType.DOCTOR_TYPE);
    }

    @Override
    public List<User> support(IFilterDetails filterDetails, List<User> users) {
        DoctorTypeFilterDetails doctorTypeFilterDetails = (DoctorTypeFilterDetails) filterDetails;
        DoctorType doctorType = doctorTypeFilterDetails.getDoctorType();

        return users.stream()
                .filter(user -> user.getUserType().equals(UserType.DOCTOR) &&
                        user.getUserProfileDetails() instanceof DoctorUserProfileDetails &&
                        ((DoctorUserProfileDetails) user.getUserProfileDetails()).getDoctorType().equals(doctorType))
                .collect(Collectors.toList());
    }
}
