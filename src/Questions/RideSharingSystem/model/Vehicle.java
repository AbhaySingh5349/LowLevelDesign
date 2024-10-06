package Questions.RideSharingSystem.model;

import Questions.RideSharingSystem.enums.VehicleType;

public class Vehicle {
    private final String id;
    private final String ownerId;
    private final VehicleType vehicleType;

    public Vehicle(String id, String ownerId, VehicleType vehicleType) {
        this.id = id;
        this.ownerId = ownerId;
        this.vehicleType = vehicleType;
    }

    public String getId() {
        return id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
