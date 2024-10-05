package Questions.TicketResolutionSystem.repository;

import Questions.TicketResolutionSystem.enums.TicketStatus;
import Questions.TicketResolutionSystem.model.Agent;
import Questions.TicketResolutionSystem.model.Ticket;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class InMemoryTicketRepo implements ITicketRepo{
    Map<String, Ticket> ticketMap;
    Map<String, Agent> ticketToAgentMap;

    public InMemoryTicketRepo() {
        this.ticketMap = new HashMap<>();
        this.ticketToAgentMap = new HashMap<>();
    }

    @Override
    public Ticket save(Ticket ticket) {
        String id = ticket.getId();
        ticketMap.put(id, ticket);

        return ticket;
    }

    @Override
    public Ticket get(String ticketId) {
        return ticketMap.get(ticketId);
    }

    @Override
    public void saveTicketAgent(String ticketId, Agent agent) {
        ticketToAgentMap.put(ticketId, agent);
    }

    public Agent getAgentForTicket(String ticketId){
        return ticketToAgentMap.get(ticketId);
    }

    @Override
    public void resolveTicket(Ticket ticket) {
        String id = ticket.getId();
        Agent agent = ticketToAgentMap.get(id);

        agent.setAvailable(true);
        ticket.setResolvedAt(new Date());
        ticket.setTicketStatus(TicketStatus.RESOLVED);

        // we can do many more tasks here (add logs, work history for agent, notify customer) -> event driven architecture
    }
}
