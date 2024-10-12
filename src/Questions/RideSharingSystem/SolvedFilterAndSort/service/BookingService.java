package Questions.RideSharingSystem.SolvedFilterAndSort.service;

import Questions.RideSharingSystem.SolvedFilterAndSort.model.Booking;
import Questions.RideSharingSystem.SolvedFilterAndSort.repository.IBookingRepo;

public class BookingService {
    private final IBookingRepo bookingRepo;

    public BookingService(IBookingRepo bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    String create(Booking booking){
        return bookingRepo.create(booking);
    }

    Booking getById(String bookingId){
        return bookingRepo.getById(bookingId);
    }
}
