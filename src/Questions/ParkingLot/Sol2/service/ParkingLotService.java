package Questions.ParkingLot.Sol2.service;

import Questions.ParkingLot.Sol2.dto.SpotSearchRequest;
import Questions.ParkingLot.Sol2.enums.SpotSortType;
import Questions.ParkingLot.Sol2.enums.SpotStatus;
import Questions.ParkingLot.Sol2.enums.SpotType;
import Questions.ParkingLot.Sol2.model.Floor;
import Questions.ParkingLot.Sol2.model.ParkingLot;
import Questions.ParkingLot.Sol2.model.Spot;
import Questions.ParkingLot.Sol2.repository.ParkingLotRepository;
import Questions.ParkingLot.Sol2.strategy.filter.ISpotSearchFilter;
import Questions.ParkingLot.Sol2.strategy.sort.ISpotSortData;
import Questions.ParkingLot.Sol2.strategy.sort.PreferredSpotTypeComparator;
import Questions.ParkingLot.Sol2.strategy.sort.TopFloorSortTypeComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class ParkingLotService {
    private final ParkingLotRepository parkingLotRepository;
    private final SpotService spotService;
    private final FloorService floorService;

    public ParkingLotService(ParkingLotRepository parkingLotRepository, SpotService spotService, FloorService floorService) {
        this.parkingLotRepository = parkingLotRepository;
        this.spotService = spotService;
        this.floorService = floorService;
    }

    public ParkingLot createParkingLot(String id, int floorCount){
        List<Floor> floors = new ArrayList<>();
        for(int i=0;i<floorCount;i++){
            int spotsCount = new Random().nextInt(3, 6);
            List<Spot> spots = new ArrayList<>();
            for(int j=0;j<spotsCount;j++){
                if(j == 0){
                    Spot spot = spotService.createSpot(id, i+1, j+1, SpotType.TRUCK);
                    spots.add(spot);
                } else if (j == 1 || j == 2) {
                    Spot spot = spotService.createSpot(id, i+1, j+1, SpotType.BIKE);
                    if(j == 1) spot.setSpotStatus(SpotStatus.OCCUPIED);
                    spots.add(spot);
                }else{
                    Spot spot = spotService.createSpot(id, i+1, j+1, SpotType.CAR);
                    spots.add(spot);
                }
            }

            Floor floor = floorService.createFloor(id, i+1, spots);
            floors.add(floor);
        }

        ParkingLot parkingLot = new ParkingLot(id, floorCount, floors);
        parkingLotRepository.addParkingLot(parkingLot);

        return parkingLot;
    }

    public void allotTicket(String parkingLotId, SpotSearchRequest searchRequest){
        String vehicleId = searchRequest.getVehicleId();
        List<ISpotSearchFilter> spotSearchFilters = searchRequest.getSpotSearchFilters();
        List<ISpotSortData> spotSortData = searchRequest.getSpotSortData();

        List<Spot> spots = spotService.getSpotsForParkingLot(parkingLotId);

        for(ISpotSearchFilter filter : spotSearchFilters){
            spots = filter.getSpots(spots);
        }

        spots.sort((s1, s2) -> {
            for(ISpotSortData data : spotSortData){
                SpotSortType sortType = data.getSortType();

                Comparator<Spot> comparator = getComparatorForSortType(sortType, data);
                int result = comparator.compare(s1, s2);
                if (result != 0) {
                    return result;
                }
            }
            return 0;
        });

        spots.forEach(System.out::println);
    }

    private Comparator<Spot> getComparatorForSortType(SpotSortType sortType, ISpotSortData data){
        return switch (sortType){
            case PREFERRED_SPOT_TYPE -> new PreferredSpotTypeComparator(data);
            case TOP_FLOOR -> new TopFloorSortTypeComparator();
            default -> throw new IllegalArgumentException("Unknown sort type: " + sortType);
        };
    }
}
