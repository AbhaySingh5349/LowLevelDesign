package Questions.RideSharingSystem.SolvedFilterAndSort.model;

import Questions.RideSharingSystem.SolvedFilterAndSort.enums.VehicleType;

public class Vehicle {
    private String id;
    private final VehicleType type;
    private final String ownerId;

    public Vehicle(VehicleType type, String ownerId) {
        this.type = type;
        this.ownerId = ownerId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public VehicleType getType() {
        return type;
    }

    public String getOwnerId() {
        return ownerId;
    }
}
