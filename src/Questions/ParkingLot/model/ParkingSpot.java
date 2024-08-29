package Questions.ParkingLot.model;

public abstract class ParkingSpot {
    private final String spotId;
    private Boolean isAvailable;
    private final String location;

    public ParkingSpot(String spotId, String location) {
        this.spotId = spotId;
        this.location = location;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getSpotId() {
        return spotId;
    }

    public String getLocation() {
        return location;
    }
}
