package Questions.RideSharingSystem.SolvedFilterAndSort.repository;

import Questions.RideSharingSystem.SolvedFilterAndSort.model.Booking;

public interface IBookingRepo {
    String create(Booking booking);
    Booking getById(String bookingId);
}
