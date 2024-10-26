package Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.repository;


import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.model.Booking;

import java.util.HashMap;
import java.util.Map;

public class InMemoryBookingRepo implements IBookingRepo{
    private Map<String, Booking> bookingMap;

    public InMemoryBookingRepo() {
        this.bookingMap = new HashMap<>();
    }

    @Override
    public void add(Booking booking) {
        String id = booking.getId();
        bookingMap.put(id, booking);
    }

    @Override
    public Booking getById(String id) {
        return bookingMap.get(id);
    }
}
