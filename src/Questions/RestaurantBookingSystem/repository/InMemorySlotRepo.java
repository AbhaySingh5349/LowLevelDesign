package Questions.RestaurantBookingSystem.repository;

import Questions.RestaurantBookingSystem.model.Slot;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemorySlotRepo implements ISlotRepo {
    // Restaurant ID -> Date -> Slots
    private final Map<String, Map<LocalDate, List<Slot>>> availableSlots;
    private final Map<String, Map<LocalDate, List<Slot>>> bookedSlots;

    public InMemorySlotRepo() {
        this.availableSlots = new HashMap<>();
        this.bookedSlots = new HashMap<>();
    }

    @Override
    public List<Slot> getAvailableSlots(String restaurantId, LocalDate date) {
        return availableSlots.getOrDefault(restaurantId, new HashMap<>()).getOrDefault(date, List.of());
    }

    @Override
    public List<Slot> getBookedSlots(String restaurantId, LocalDate date) {
        return bookedSlots.getOrDefault(restaurantId, new HashMap<>()).getOrDefault(date, List.of());
    }

    @Override
    public void addAvailableSlots(String restaurantId, Map<LocalDate, List<Slot>> slotsForDays) {
        availableSlots.computeIfAbsent(restaurantId, id -> new HashMap<>()).putAll(slotsForDays);
    }

    @Override
    public void removeAvailableSlot(String restaurantId, Slot slot) {
        LocalDate date = slot.getDate();
        Map<LocalDate, List<Slot>> dateSlots = availableSlots.getOrDefault(restaurantId, new HashMap<>());
        dateSlots.getOrDefault(date, new ArrayList<>()).remove(slot);
    }

    @Override
    public void addBookedSlot(String restaurantId, Slot slot) {
        LocalDate date = slot.getDate();
        bookedSlots.computeIfAbsent(restaurantId, id -> new HashMap<>())
                .computeIfAbsent(date, d -> new ArrayList<>()).add(slot);
    }

    @Override
    public boolean isSlotAvailable(String restaurantId, Slot slot) {
        LocalDate date = slot.getDate();
        return getAvailableSlots(restaurantId, date).contains(slot);
    }

    // get available slots for a restaurant on a given date and between a time range
    @Override
    public List<Slot> getAvailableSlotsForRestaurantWithinTimeRange(String restaurantId, LocalDate date, LocalTime startTime, LocalTime endTime) {
        List<Slot> availableSlots = getAvailableSlots(restaurantId, date);
        return availableSlots.stream()
                .filter(slot -> slot.getStartTime().isAfter(startTime) && slot.getEndTime().isBefore(endTime))
                .collect(Collectors.toList());
    }

    // Get available slots for a restaurant on a given date and before a specific time
    @Override
    public List<Slot> getAvailableSlotsForRestaurantBeforeTime(String restaurantId, LocalDate date, LocalTime time) {
        List<Slot> availableSlots = getAvailableSlots(restaurantId, date);
        return availableSlots.stream()
                .filter(slot -> slot.getEndTime().isBefore(time))
                .collect(Collectors.toList());
    }

    // Get available slots for a restaurant on a given date and after a specific time
    @Override
    public List<Slot> getAvailableSlotsForRestaurantAfterTime(String restaurantId, LocalDate date, LocalTime time) {
        List<Slot> availableSlots = getAvailableSlots(restaurantId, date);
        return availableSlots.stream()
                .filter(slot -> slot.getStartTime().isAfter(time))
                .collect(Collectors.toList());
    }
}
