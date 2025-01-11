package Questions.DoctorBookingSystem.strategy.sort;

import Questions.DoctorBookingSystem.model.User;

public interface ISort {
    boolean doesSupport(ISortDetails sortDetails);
    int support(ISortDetails sortDetails, User u1, User u2);
}
