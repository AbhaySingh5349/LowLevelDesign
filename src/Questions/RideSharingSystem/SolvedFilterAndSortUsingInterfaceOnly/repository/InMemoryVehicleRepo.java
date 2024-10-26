package Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.repository;

import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.model.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class InMemoryVehicleRepo implements IVehicleRepo{
    private Map<String, Vehicle> vehicleMap;

    public InMemoryVehicleRepo() {
        this.vehicleMap = new HashMap<>();
    }

    @Override
    public void add(Vehicle vehicle) {
        String id = vehicle.getId();
        vehicleMap.put(id, vehicle);
    }

    @Override
    public Vehicle getById(String id) {
        return vehicleMap.get(id);
    }
}
