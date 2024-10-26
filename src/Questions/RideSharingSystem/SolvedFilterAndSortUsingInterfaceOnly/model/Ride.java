package Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ride {
    private final String id;
    private final String userId;
    private final Vehicle vehicle;
    private final String src;
    private final String dst;
    private final Date startTime;
    private final int durationMinutes;
    private int availableSeats;
    private final List<Booking> bookings;

    public Ride(String id, String userId, Vehicle vehicle, String src, String dst, int durationMinutes) {
        this.id = id;
        this.userId = userId;
        this.vehicle = vehicle;
        this.src = src;
        this.dst = dst;
        this.startTime = new Date();
        this.durationMinutes = durationMinutes;
        this.availableSeats = vehicle.getType().getSeatCount();
        this.bookings = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getSrc() {
        return src;
    }

    public String getDst() {
        return dst;
    }

    public Date getStartTime() {
        return startTime;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats += availableSeats;
    }

    public Date endTime(){
        long minutesInMillis = (long) this.durationMinutes * 60 * 1000;
        return new Date(startTime.getTime() + minutesInMillis);
    }

    @Override
    public String toString() {
        return "Ride{" +
                "numSeats=" + availableSeats +
                ", src='" + src + '\'' +
                ", dst='" + dst + '\'' +
                ", vehicleType='" + vehicle.getType() + '\'' +
                ", startTime=" + startTime +
                '}';
    }
}
