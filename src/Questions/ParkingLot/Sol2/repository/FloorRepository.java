package Questions.ParkingLot.Sol2.repository;

import Questions.ParkingLot.Sol2.model.Floor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FloorRepository {
    private final Map<String, Floor> floorMap;

    public FloorRepository() {
        this.floorMap = new HashMap<>();
    }

    public void addFloor(Floor floor){
        floorMap.put(floor.getId(), floor);
    }

    public Floor getFloorById(String id){
        return floorMap.get(id);
    }

    public List<Floor> getFloorsForParkingLot(String parkingLotId){
        List<Floor> floors = new ArrayList<>(floorMap.values());
        return floors.stream().filter(floor -> floor.getParkingLotId().equals(parkingLotId)).collect(Collectors.toList());
    }
}
