package Questions.RideSharingSystem.repository;

import Questions.RideSharingSystem.model.Booking;

public interface IBookingRepo {
    String add(Booking booking);
    Booking get(String bookingId);
}
