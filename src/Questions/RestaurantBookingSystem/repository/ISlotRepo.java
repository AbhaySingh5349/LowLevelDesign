package Questions.RestaurantBookingSystem.repository;

import Questions.RestaurantBookingSystem.model.Slot;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ISlotRepo {
    List<Slot> getAvailableSlots(String restaurantId, LocalDate date);

    List<Slot> getBookedSlots(String restaurantId, LocalDate date);

    void addAvailableSlots(String restaurantId, Map<LocalDate, List<Slot>> slotsForDays);

    void addBookedSlot(String restaurantId, Slot slot);

    void removeAvailableSlot(String restaurantId, Slot slot);

    boolean isSlotAvailable(String restaurantId, Slot slot);
}
