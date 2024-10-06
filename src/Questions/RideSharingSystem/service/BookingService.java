package Questions.RideSharingSystem.service;

import Questions.RideSharingSystem.model.Booking;
import Questions.RideSharingSystem.model.Location;
import Questions.RideSharingSystem.model.Ride;
import Questions.RideSharingSystem.model.User;
import Questions.RideSharingSystem.repository.IBookingRepo;

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
