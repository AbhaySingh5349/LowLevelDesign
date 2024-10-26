package Questions.RideSharingSystem.SolvedFilterAndSortUsingGenerics.repository;

import Questions.RideSharingSystem.SolvedFilterAndSortUsingGenerics.model.Booking;

public interface IBookingRepo {
    String create(Booking booking);
    Booking getById(String bookingId);
}
