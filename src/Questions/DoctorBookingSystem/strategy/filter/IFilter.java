package Questions.DoctorBookingSystem.strategy.filter;

import Questions.DoctorBookingSystem.model.User;

import java.util.List;

public interface IFilter {
    boolean doesSupport(IFilterDetails filterDetails);
    List<User> support(IFilterDetails filterDetails, List<User> users);
}
