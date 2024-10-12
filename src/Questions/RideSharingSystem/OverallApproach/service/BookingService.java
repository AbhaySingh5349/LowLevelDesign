package Questions.RideSharingSystem.OverallApproach.service;

import Questions.RideSharingSystem.OverallApproach.model.Booking;
import Questions.RideSharingSystem.OverallApproach.model.Location;
import Questions.RideSharingSystem.OverallApproach.model.Ride;
import Questions.RideSharingSystem.OverallApproach.model.User;
import Questions.RideSharingSystem.OverallApproach.repository.IBookingRepo;

public class BookingService {
    private final IBookingRepo bookingRepo;

    public BookingService(IBookingRepo bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    public String createBooking(Ride ride, User bookedBy, Integer seatsBooked, Location startLocation, Location endLocation){
        Booking booking = new Booking(ride, bookedBy, seatsBooked, startLocation, endLocation);
        return bookingRepo.add(booking);
    }

    public Booking getBooking(String bookingId){
        return bookingRepo.get(bookingId);
    }
}
