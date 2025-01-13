package Questions.ParkingLot.Sol2.repository;

import Questions.ParkingLot.Sol2.model.Spot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SpotRepository {
    private final Map<String, Spot> spotMap;

    public SpotRepository() {
        this.spotMap = new HashMap<>();
    }

    public void addSpot(Spot spot){
        spotMap.put(spot.getId(), spot);
    }

    public Spot getSpotById(String id){
        return spotMap.get(id);
    }

    public List<Spot> getSpotsForParkingLot(String parkingLotId){
        return spotMap.values().stream().filter(spot -> spot.getParkingLotId().equals(parkingLotId)).collect(Collectors.toList());
    }

    public List<Spot> getSpotsForParkingLotAndFloor(String parkingLotId, int floorNum){
        return spotMap.values().stream().filter(spot -> spot.getParkingLotId().equals(parkingLotId) && spot.getFloorNum() == floorNum).collect(Collectors.toList());
    }
}
