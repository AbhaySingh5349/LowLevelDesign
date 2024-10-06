package Questions.RideSharingSystem.model;

import Questions.RideSharingSystem.enums.RideStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ride {
    private final User driver;
    private final Vehicle vehicle;
    private final List<Booking> bookings;
    private final List<RideStop> rideStops;
    private int availableSeats;
    private RideStatus rideStatus;

    public Ride(User driver, Vehicle vehicle) {
        this.driver = driver;
        this.vehicle = vehicle;
        this.bookings = new ArrayList<>();
        this.rideStops = new ArrayList<>();
        this.availableSeats = vehicle.getVehicleType().getDefaultSeats();
        this.rideStatus = RideStatus.CREATED;
    }

    public User getDriver() {
        return driver;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public List<RideStop> getRideStops() {
        return rideStops;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int seatsCount) {
        this.availableSeats += seatsCount;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }

    public Boolean hasPath(Location startLocation, Location endLocation){
        List<String> locations = rideStops.stream().map(rideStop -> rideStop.getLocation().getName()).collect(Collectors.toList());
        return locations.contains(startLocation.getName()) && locations.contains(endLocation.getName());
    }
}
