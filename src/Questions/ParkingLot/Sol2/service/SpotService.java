package Questions.ParkingLot.Sol2.service;

import Questions.ParkingLot.Sol2.enums.SpotType;
import Questions.ParkingLot.Sol2.model.Spot;
import Questions.ParkingLot.Sol2.repository.SpotRepository;

import java.util.List;

public class SpotService {
    private final SpotRepository spotRepository;

    public SpotService(SpotRepository spotRepository) {
        this.spotRepository = spotRepository;
    }

    public Spot createSpot(String parkingLotId, int floorNum, int spotNum, SpotType spotType){
        Spot spot = new Spot(parkingLotId, floorNum, spotNum, spotType);
        spotRepository.addSpot(spot);

        return spot;
    }

    public Spot getSpotById(String id){
        return spotRepository.getSpotById(id);
    }

    public List<Spot> getSpotsForParkingLot(String parkingLotId){
        return spotRepository.getSpotsForParkingLot(parkingLotId);
    }

    public List<Spot> getSpotsForParkingLotAndFloor(String parkingLotId, int floorNum){
        return spotRepository.getSpotsForParkingLotAndFloor(parkingLotId, floorNum);
    }
}
