package Questions.RideSharingSystem.SolvedFilterAndSortUsingGenerics.repository;

import Questions.RideSharingSystem.SolvedFilterAndSortUsingGenerics.model.Booking;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class InMemoryBookingRepo implements IBookingRepo{
    Map<String, Booking> bookingMap;

    public InMemoryBookingRepo() {
        this.bookingMap = new HashMap<>();
    }

    @Override
    public String create(Booking booking) {
        String  id = UUID.randomUUID().toString();
        booking.setId(id);
        bookingMap.put(id, booking);
        return id;
    }

    @Override
    public Booking getById(String bookingId) {
        return bookingMap.get(bookingId);
    }
}
