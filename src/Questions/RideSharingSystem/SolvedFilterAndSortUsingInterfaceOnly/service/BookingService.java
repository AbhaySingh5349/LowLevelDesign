package Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.service;

import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.model.Booking;
import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.repository.IBookingRepo;

public class BookingService {
    private final IBookingRepo bookingRepo;

    public BookingService(IBookingRepo bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    public void create(Booking booking){
        bookingRepo.add(booking);
    }

    public Booking getById(String id){
        return bookingRepo.getById(id);
    }
}
