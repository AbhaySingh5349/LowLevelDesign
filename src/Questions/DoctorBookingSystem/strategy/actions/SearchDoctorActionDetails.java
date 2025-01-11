package Questions.DoctorBookingSystem.strategy.actions;

import Questions.DoctorBookingSystem.enums.UserType;
import Questions.DoctorBookingSystem.strategy.filter.IFilterDetails;
import Questions.DoctorBookingSystem.strategy.sort.ISortDetails;

import java.util.List;

public class SearchDoctorActionDetails implements IActionDetails{
    private final List<IFilterDetails> userFilterDetails;
    private final List<ISortDetails> userSortDetails;
    private final UserType userType;
    private final String userId;

    public SearchDoctorActionDetails(List<IFilterDetails> userFilterDetails, List<ISortDetails> userSortDetails, UserType userType, String userId) {
        this.userFilterDetails = userFilterDetails;
        this.userSortDetails = userSortDetails;
        this.userType = userType;
        this.userId = userId;
    }

    public List<IFilterDetails> getUserFilterDetails() {
        return userFilterDetails;
    }

    public List<ISortDetails> getUserSortDetails() {
        return userSortDetails;
    }

    public UserType getUserType() {
        return userType;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public boolean doesSupport(UserType userType) {
        return userType.equals(UserType.DOCTOR) || userType.equals(UserType.PATIENT);
    }
}
