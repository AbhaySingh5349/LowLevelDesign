package Questions.RestaurantBookingSystem.repository;

import Questions.RestaurantBookingSystem.model.Slot;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
