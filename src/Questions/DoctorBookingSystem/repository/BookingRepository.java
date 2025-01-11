package Questions.DoctorBookingSystem.repository;

import Questions.DoctorBookingSystem.model.Booking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingRepository {
    private final Map<String, List<Booking>> bookingMap;

    public BookingRepository() {
        this.bookingMap = new HashMap<>();
    }

    public void add(Booking booking){
        bookingMap.computeIfAbsent(booking.getDoctorId(), k -> new ArrayList<>()).add(booking);
    }

    public List<Booking> get(String doctorId){
        return bookingMap.getOrDefault(doctorId, List.of());
    }
}
