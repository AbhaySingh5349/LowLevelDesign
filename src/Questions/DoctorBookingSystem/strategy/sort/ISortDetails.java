package Questions.DoctorBookingSystem.strategy.sort;

import Questions.DoctorBookingSystem.enums.SortType;

public interface ISortDetails {
    boolean doesSupport(SortType sortType);
}
