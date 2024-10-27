package Questions.RestaurantBookingSystem.repository;

import Questions.RestaurantBookingSystem.model.Booking;
import Questions.RestaurantBookingSystem.model.Slot;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryBookingRepo implements IBookingRepo{
    private final Map<String, Booking> bookingMap;
    private final Map<String, Map<LocalDate, List<Slot>>> restaurantBookings;

    public InMemoryBookingRepo() {
        this.restaurantBookings = new HashMap<>();
        this.bookingMap = new HashMap<>();
    }

    @Override
    public void add(Booking booking, String restaurantId) {
        String id = booking.getId();
        bookingMap.put(id, booking);
    }

    @Override
    public Booking getBookingById(String id) {
        return bookingMap.get(id);
    }

    @Override
    public List<Booking> getAllBookings() {
        return new ArrayList<>(bookingMap.values());
    }

    public Map<LocalDate, List<Slot>> getRestaurantBookings(String id) {
        return restaurantBookings.get(id);
    }
}
