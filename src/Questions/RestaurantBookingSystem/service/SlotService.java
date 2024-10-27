package Questions.RestaurantBookingSystem.service;

import Questions.RestaurantBookingSystem.model.Restaurant;
import Questions.RestaurantBookingSystem.model.Slot;
import Questions.RestaurantBookingSystem.repository.ISlotRepo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class SlotService {
    private final ISlotRepo slotRepo;

    public SlotService(ISlotRepo slotRepo) {
        this.slotRepo = slotRepo;
    }

    // Generates 1-hour slots within the opening and closing time for a specific date
    public static List<Slot> generateSlotsForDay(LocalDate date, LocalTime openingTime, LocalTime closingTime) {
        List<Slot> slots = new ArrayList<>();
        LocalTime currentTime = openingTime;

        while (currentTime.isBefore(closingTime)) {
            slots.add(new Slot(date, currentTime));
            currentTime = currentTime.plusHours(1); // Move to the next hour slot
        }

        return slots;
    }

    // Generates 1-hour slots for the next k days
    public static Map<LocalDate, List<Slot>> generateSlotsForNextKDays(int k, LocalTime openingTime, LocalTime closingTime) {
        Map<LocalDate, List<Slot>> slotsForDays = new HashMap<>();
        LocalDate currentDate = LocalDate.now();

        for (int i = 0; i < k; i++) {
            List<Slot> dailySlots = generateSlotsForDay(currentDate, openingTime, closingTime);
            slotsForDays.put(currentDate, dailySlots);
            currentDate = currentDate.plusDays(1); // Move to the next day
        }

        return slotsForDays;
    }

    // Initialize slots for a restaurant for the next k days
    public void initializeSlots(Restaurant restaurant, int k) {
        Map<LocalDate, List<Slot>> slotsForDays = generateSlotsForNextKDays(k, restaurant.getOpeningTime(), restaurant.getClosingTime());
        slotRepo.addAvailableSlots(restaurant.getId(), slotsForDays);
    }

    // Check available slots for a restaurant on a specific date
    public List<Slot> getAvailableSlots(String restaurantId, LocalDate date) {
        return slotRepo.getAvailableSlots(restaurantId, date);
    }

    // Check booked slots for a restaurant on a specific date
    public List<Slot> getBookedSlots(String restaurantId, LocalDate date){
        return slotRepo.getBookedSlots(restaurantId, date);
    }

    // Book a slot if available
    public void bookSlot(String restaurantId, Slot slot) {
//        synchronized (slot){
//            if(isSlotAvailable(restaurantId, slot)){
//                slotRepo.removeAvailableSlot(restaurantId, slot);
//                slotRepo.addBookedSlot(restaurantId, slot);
//            }
//        }

        slotRepo.removeAvailableSlot(restaurantId, slot);
        slotRepo.addBookedSlot(restaurantId, slot);
    }

    public boolean isSlotAvailable(String restaurantId, Slot slot){
        return slotRepo.isSlotAvailable(restaurantId, slot);
    }
}