package Questions.DoctorBookingSystem.service;

import Questions.DoctorBookingSystem.repository.BookingRepository;

public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }
}
