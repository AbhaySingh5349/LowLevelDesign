package Questions.ParkingLot.service;

public class ParkingLotService {
    private EntranceService entranceService;
    private ExitService exitService;

    public ParkingLotService(EntranceService entranceService, ExitService exitService) {
        this.entranceService = entranceService;
        this.exitService = exitService;
    }

    public void enterParkingLot() {
        entranceService.issueTicket();
    }

    public void exitParkingLot(String ticketId) {
        exitService.processExit(ticketId);
    }
}
