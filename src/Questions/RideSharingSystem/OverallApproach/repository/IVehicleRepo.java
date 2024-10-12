package Questions.RideSharingSystem.OverallApproach.repository;

import Questions.RideSharingSystem.OverallApproach.model.Vehicle;

public interface IVehicleRepo {
    void add(Vehicle vehicle);
    Vehicle get(String vehicleId);
}
