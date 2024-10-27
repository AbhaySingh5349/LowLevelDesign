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
}