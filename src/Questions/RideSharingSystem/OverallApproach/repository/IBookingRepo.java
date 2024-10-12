package Questions.RideSharingSystem.OverallApproach.repository;

import Questions.RideSharingSystem.OverallApproach.model.Booking;

public interface IBookingRepo {
    String add(Booking booking);
    Booking get(String bookingId);
}
