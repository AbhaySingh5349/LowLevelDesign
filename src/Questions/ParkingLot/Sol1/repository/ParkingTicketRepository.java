package Questions.ParkingLot.Sol1.repository;

import Questions.ParkingLot.Sol1.model.ParkingTicket;

import java.util.HashMap;
import java.util.Map;

public class ParkingTicketRepository {
    private final Map<String, ParkingTicket> parkingTickets = new HashMap<>();

    public ParkingTicket getTicketById(String ticketId) {
        return parkingTickets.get(ticketId);
    }

    public void addTicket(ParkingTicket ticket) {
        parkingTickets.put(ticket.getTicketId(), ticket);
    }

    public void updateTicket(ParkingTicket ticket) {
        parkingTickets.put(ticket.getTicketId(), ticket);
    }
}
