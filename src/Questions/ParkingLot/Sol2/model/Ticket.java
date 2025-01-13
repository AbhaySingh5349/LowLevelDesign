package Questions.ParkingLot.Sol2.model;

import java.time.LocalTime;

public class Ticket {
    private final String id;
    private final String spotId;
    private final String vehicleId;
    private final LocalTime createdAt;

    public Ticket(String id, String spotId, String vehicleId, LocalTime createdAt) {
        this.id = id;
        this.spotId = spotId;
        this.vehicleId = vehicleId;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public String getSpotId() {
        return spotId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public LocalTime getCreatedAt() {
        return createdAt;
    }
}
