package Questions.ParkingLot.Sol2.service;

import Questions.ParkingLot.Sol2.model.Floor;
import Questions.ParkingLot.Sol2.model.Spot;
import Questions.ParkingLot.Sol2.repository.FloorRepository;

import java.util.List;

public class FloorService {
    private final FloorRepository floorRepository;

    public FloorService(FloorRepository floorRepository) {
        this.floorRepository = floorRepository;
    }

    public Floor createFloor(String parkingLotId, int floorNum, List<Spot> spots){
        Floor floor = new Floor(parkingLotId, floorNum, spots);
        floorRepository.addFloor(floor);

        return floor;
    }

    public Floor getFloorById(String id){
        return floorRepository.getFloorById(id);
    }

    public List<Floor> getFloorsForParkingLot(String parkingLotId){
        return floorRepository.getFloorsForParkingLot(parkingLotId);
    }
}
