package Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.model;

import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.enums.VehicleType;

public class Vehicle {
    private final String id;
    private final String userId;
    private final VehicleType type;

    public Vehicle(String id, String userId, VehicleType type) {
        this.id = id;
        this.userId = userId;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public VehicleType getType() {
        return type;
    }
}
