package Questions.RideSharingSystem.repository;

import Questions.RideSharingSystem.model.Vehicle;

public interface IVehicleRepo {
    void add(Vehicle vehicle);
    Vehicle get(String vehicleId);
}
