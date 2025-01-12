package Questions.DoctorBookingSystem.repository;

import Questions.DoctorBookingSystem.model.Booking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookingRepository {
    private final Map<String, List<Booking>> bookingMap;

    public BookingRepository() {
        this.bookingMap = new HashMap<>();
    }

    public Map<String, List<Booking>> getBookingMap() {
        return bookingMap;
    }

    public void add(Booking booking){
        bookingMap.computeIfAbsent(booking.getDoctorId(), k -> new ArrayList<>()).add(booking);
    }

    public List<Booking> get(String doctorId){
        return bookingMap.getOrDefault(doctorId, List.of());
    }

    public List<Booking> getAllBookings(){
        return bookingMap.values().stream() // Get all values (lists of bookings)
                .flatMap(bookings -> bookings.stream()) // Use a lambda instead of method reference
                .collect(Collectors.toList()); // Collect into a single list
    }
}
