package Questions.RestaurantBookingSystem.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Slot {
    private final LocalDate date;
    private final LocalTime startTime;
    private final LocalTime endTime;

    public Slot(LocalDate date, LocalTime startTime) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = startTime.plusHours(1); // Ensures a 1-hour window
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, startTime, endTime);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Slot)) return false;
        Slot other = (Slot) obj;
        return date.equals(other.date) &&
                startTime.equals(other.startTime) &&
                endTime.equals(other.endTime);
    }

    @Override
    public String toString() {
        return "Slot{" +
                "date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
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
}