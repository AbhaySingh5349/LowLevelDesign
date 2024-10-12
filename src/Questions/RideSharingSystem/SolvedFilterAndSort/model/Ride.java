package Questions.RideSharingSystem.SolvedFilterAndSort.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ride {
    private String id;
    private final String driverId;
    private final Vehicle vehicle;
    private final String src;
    private final String dst;
    private final List<Booking> bookings;
    private final Date startTime;
    private final int durationMinutes;
    private int availableSeats;

    public Ride(String driverId, Vehicle vehicle, String src, String dst, int durationMinutes) {
        this.driverId = driverId;
        this.vehicle = vehicle;
        this.src = src;
        this.dst = dst;
        this.bookings = new ArrayList<>();
        this.startTime = new Date();
        this.durationMinutes = durationMinutes;
        this.availableSeats = vehicle.getType().getSeats();
    }

    public String getId() {
        return id;
    }

    public String getDriverId() {
        return driverId;
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

    public List<Booking> getBookings() {
        return bookings;
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

    public void setId(String id) {
        this.id = id;
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
