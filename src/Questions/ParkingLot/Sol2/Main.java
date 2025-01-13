package Questions.ParkingLot.Sol2;

import Questions.ParkingLot.Sol2.dto.SpotSearchRequest;
import Questions.ParkingLot.Sol2.enums.SpotStatus;
import Questions.ParkingLot.Sol2.enums.SpotType;
import Questions.ParkingLot.Sol2.model.Spot;
import Questions.ParkingLot.Sol2.repository.FloorRepository;
import Questions.ParkingLot.Sol2.repository.ParkingLotRepository;
import Questions.ParkingLot.Sol2.repository.SpotRepository;
import Questions.ParkingLot.Sol2.service.FloorService;
import Questions.ParkingLot.Sol2.service.ParkingLotService;
import Questions.ParkingLot.Sol2.service.SpotService;
import Questions.ParkingLot.Sol2.strategy.filter.ISpotSearchFilter;
import Questions.ParkingLot.Sol2.strategy.filter.SpotStatusSearch;
import Questions.ParkingLot.Sol2.strategy.sort.ISpotSortData;
import Questions.ParkingLot.Sol2.strategy.sort.PreferredSpotTypeSortData;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SpotRepository spotRepository = new SpotRepository();
        SpotService spotService = new SpotService(spotRepository);

        FloorRepository floorRepository = new FloorRepository();
        FloorService floorService = new FloorService(floorRepository);

        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingLotService parkingLotService = new ParkingLotService(parkingLotRepository, spotService, floorService);

        parkingLotService.createParkingLot("p1", 2);

        List<Spot> allSpots = spotService.getSpotsForParkingLot("p1");
        System.out.println("######################################################################");
        allSpots.forEach(System.out::println);
        System.out.println("######################################################################");

        List<ISpotSearchFilter> filters = Arrays.asList(new SpotStatusSearch(SpotStatus.AVAILABLE));
        List<ISpotSortData> sortData = Arrays.asList(new PreferredSpotTypeSortData(SpotType.TRUCK));
        SpotSearchRequest searchRequest = new SpotSearchRequest("v1", filters, sortData);
        parkingLotService.allotTicket("p1", searchRequest);
    }
}
