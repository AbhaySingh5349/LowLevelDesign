package Questions.DoctorBookingSystem.strategy.sort;

import Questions.DoctorBookingSystem.model.Slot;
import Questions.DoctorBookingSystem.model.User;
import Questions.DoctorBookingSystem.repository.SlotRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EarliestSlotAvailabilityComparator implements Comparator<User> {
    private final SlotRepository slotRepository;

    public EarliestSlotAvailabilityComparator(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    @Override
    public int compare(User u1, User u2) {
//        List<Slot> d1_slots = slotRepository.getAvailableSlots(u1.getId());
//        List<Slot> d2_slots = slotRepository.getAvailableSlots(u2.getId());

        // to allow queuing for multiple patients for same slot
        List<Slot> d1_slots = slotRepository.getAllSlots(u1.getId());
        List<Slot> d2_slots = slotRepository.getAllSlots(u2.getId());

        Slot earliestSlot_1 = d1_slots.stream()
                .min((s1, s2) -> s1.getStartTime().compareTo(s2.getStartTime()))
                .orElse(null);

        Slot earliestSlot_2 = d2_slots.stream()
                .min((s1, s2) -> s1.getStartTime().compareTo(s2.getStartTime()))
                .orElse(null);

//        System.out.println("***********************************");
//        System.out.println(u1.getId() + " -> " + earliestSlot_1);
//        System.out.println(u2.getId() + " -> " + earliestSlot_2);
//        System.out.println("***********************************");

        if (earliestSlot_1 == null && earliestSlot_2 == null) {
            return 0; // Both users have no available slots
        } else if (earliestSlot_1 == null) {
            return 1; // User 1 has no available slots, User 2 comes first
        } else if (earliestSlot_2 == null) {
            return -1; // User 2 has no available slots, User 1 comes first
        } else {
            // Compare based on the start time of the earliest slots
            return earliestSlot_1.getStartTime().compareTo(earliestSlot_2.getStartTime());
        }
    }
}
