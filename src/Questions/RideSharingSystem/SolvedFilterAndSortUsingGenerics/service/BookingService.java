package Questions.RideSharingSystem.SolvedFilterAndSortUsingGenerics.service;

import Questions.RideSharingSystem.SolvedFilterAndSortUsingGenerics.model.Booking;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingGenerics.repository.IBookingRepo;

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
