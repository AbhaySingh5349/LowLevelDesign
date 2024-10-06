package Questions.RideSharingSystem.repository;

import Questions.RideSharingSystem.model.Booking;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class InMemoryBookingRepo implements IBookingRepo{
    Map<String, Booking> bookingMap;

    public InMemoryBookingRepo() {
        bookingMap = new HashMap<>();
    }

    @Override
    public String add(Booking booking) {
        String id = UUID.randomUUID().toString();
        bookingMap.put(id, booking);

        return id;
    }

    @Override
    public Booking get(String bookingId) {
        return null;
    }
}
