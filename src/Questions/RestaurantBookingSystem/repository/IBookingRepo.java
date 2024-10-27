package Questions.RestaurantBookingSystem.repository;


import Questions.RestaurantBookingSystem.model.Booking;
import Questions.RestaurantBookingSystem.model.Restaurant;
import Questions.RestaurantBookingSystem.model.Slot;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IBookingRepo {
    void add(Booking booking, String restaurantId);
    Booking getBookingById(String id);
    List<Booking> getAllBookings();
    List<Booking> getRestaurantBookings(String restaurantId);
}
