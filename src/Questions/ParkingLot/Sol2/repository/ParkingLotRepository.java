package Questions.ParkingLot.Sol2.repository;

import Questions.ParkingLot.Sol2.model.ParkingLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotRepository {
    private final Map<String, ParkingLot> parkingLotMap;

    public ParkingLotRepository() {
        this.parkingLotMap = new HashMap<>();
    }

    public void addParkingLot(ParkingLot parkingLot){
        parkingLotMap.put(parkingLot.getId(), parkingLot);
    }

    public List<ParkingLot> getAllParkingLots(){
        return new ArrayList<>(parkingLotMap.values());
    }

    public ParkingLot getParkingLotById(String id){
        return parkingLotMap.get(id);
    }
}
