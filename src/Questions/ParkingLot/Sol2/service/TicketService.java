package Questions.ParkingLot.Sol2.service;

import Questions.ParkingLot.Sol2.enums.SpotStatus;
import Questions.ParkingLot.Sol2.enums.SpotType;
import Questions.ParkingLot.Sol2.model.Spot;
import Questions.ParkingLot.Sol2.model.Ticket;
import Questions.ParkingLot.Sol2.repository.TicketRepository;
import Questions.ParkingLot.Sol2.strategy.pricing.HourlyPricingDetails;
import Questions.ParkingLot.Sol2.strategy.pricing.IPricing;
import Questions.ParkingLot.Sol2.strategy.pricing.IPricingDetails;
import Questions.ParkingLot.Sol2.strategy.pricing.SpotTypePricingDetails;

import java.time.LocalTime;
import java.util.List;

public class TicketService {
    private final TicketRepository ticketRepository;
    private final SpotService spotService;
    private final List<IPricing> pricings;

    public TicketService(TicketRepository ticketRepository, SpotService spotService, List<IPricing> pricings) {
        this.ticketRepository = ticketRepository;
        this.spotService = spotService;
        this.pricings = pricings;
    }

    public Ticket createTicket(String id, String spotId, String vehicleId, LocalTime createdAt){
        Ticket ticket = new Ticket(id, spotId, vehicleId, createdAt);
        ticketRepository.addTicket(ticket);

        Spot spot = spotService.getSpotById(spotId);
        spot.setSpotStatus(SpotStatus.OCCUPIED);

        return ticket;
    }

    public int calculatePriceOnExit(String ticketId){
        Ticket ticket = ticketRepository.getById(ticketId);

        LocalTime createdAt = ticket.getCreatedAt();
        int duration = 120; // minutes
        HourlyPricingDetails hourlyPricingDetails = new HourlyPricingDetails(duration);

        String spotId = ticket.getSpotId();
        Spot spot = spotService.getSpotById(spotId);
        SpotTypePricingDetails spotTypePricingDetails = new SpotTypePricingDetails(spot.getSpotType());

        List<IPricingDetails> pricingDetails = List.of(hourlyPricingDetails, spotTypePricingDetails);

        int fare = 0;

        for (IPricing pricing : pricings){
            for(IPricingDetails details : pricingDetails){
                if(pricing.doesSupport(details)){
                    fare += pricing.getFare(details);
                }
            }
        }

        return fare;
    }
}
