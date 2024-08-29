package Questions.ParkingLot.service;

import Questions.ParkingLot.model.ParkingSpot;
import Questions.ParkingLot.model.ParkingTicket;
import Questions.ParkingLot.repository.ParkingSpotRepository;
import Questions.ParkingLot.repository.ParkingTicketRepository;
import Questions.ParkingLot.strategy.ParkingStrategy;

import java.util.UUID;

public class EntranceService {
    private final ParkingSpotRepository spotRepository;
    private final ParkingTicketRepository ticketRepository;
    private final ParkingStrategy parkingStrategy;

    public EntranceService(ParkingSpotRepository spotRepository, ParkingTicketRepository ticketRepository, ParkingStrategy parkingStrategy) {
        this.spotRepository = spotRepository;
        this.ticketRepository = ticketRepository;
        this.parkingStrategy = parkingStrategy;
    }

    public ParkingTicket issueTicket() {
        ParkingSpot spot = parkingStrategy.findSpot(spotRepository.getAvailableSpots());
        if (spot != null) {
            spot.setAvailable(false);
            spotRepository.updateSpot(spot);

            ParkingTicket ticket = new ParkingTicket(UUID.randomUUID().toString(), spot);
            ticketRepository.addTicket(ticket);
            return ticket;
        }
        return null;
    }
}
