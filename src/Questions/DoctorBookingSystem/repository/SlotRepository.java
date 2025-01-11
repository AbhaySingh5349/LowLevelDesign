package Questions.DoctorBookingSystem.repository;


import Questions.DoctorBookingSystem.model.Slot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SlotRepository {
    private final Map<String, List<Slot>> slotMap;

    public SlotRepository() {
        this.slotMap = new HashMap<>();
    }

    public void add(List<Slot> slots, String doctorId){
        slotMap.computeIfAbsent(doctorId, k -> new ArrayList<>()).addAll(slots);
    }

    public List<Slot> getAvailableSlots(String doctorId){
        List<Slot> slots = slotMap.getOrDefault(doctorId, new ArrayList<>());

        return slots.stream().filter(Slot::isAvailable).collect(Collectors.toList());
    }
}
