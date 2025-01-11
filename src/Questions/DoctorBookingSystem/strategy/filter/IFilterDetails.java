package Questions.DoctorBookingSystem.strategy.filter;

import Questions.DoctorBookingSystem.enums.FilterType;

public interface IFilterDetails {
    boolean doesSupport(FilterType filterType);
}
