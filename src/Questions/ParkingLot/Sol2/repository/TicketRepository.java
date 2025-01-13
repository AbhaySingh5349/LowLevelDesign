package Questions.ParkingLot.Sol2.repository;

import Questions.ParkingLot.Sol2.model.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    private final Map<String, Ticket> ticketMap;

    public TicketRepository() {
        this.ticketMap = new HashMap<>();
    }

    public void addTicket(Ticket ticket){
        ticketMap.put(ticket.getId(), ticket);
    }

    public Ticket getById(String id){
        return ticketMap.get(id);
    }
}
