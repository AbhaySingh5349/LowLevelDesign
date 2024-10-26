package Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.repository;

import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.model.Vehicle;

public interface IVehicleRepo {
    void add(Vehicle vehicle);
    Vehicle getById(String id);
}
