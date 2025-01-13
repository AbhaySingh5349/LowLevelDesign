package Questions.ParkingLot.Sol1.service;

import Questions.ParkingLot.Sol1.model.ParkingSpot;
import Questions.ParkingLot.Sol1.model.ParkingTicket;
import Questions.ParkingLot.Sol1.repository.ParkingSpotRepository;
import Questions.ParkingLot.Sol1.repository.ParkingTicketRepository;
import Questions.ParkingLot.Sol1.strategy.ParkingStrategy;

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
