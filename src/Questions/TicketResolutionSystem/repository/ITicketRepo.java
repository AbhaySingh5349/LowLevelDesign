package Questions.TicketResolutionSystem.repository;

import Questions.TicketResolutionSystem.model.Agent;
import Questions.TicketResolutionSystem.model.Ticket;

public interface ITicketRepo {
    Ticket save(Ticket ticket);
    Ticket get(String ticketId);
    void saveTicketAgent(String ticketId, Agent agent);
    void resolveTicket(Ticket ticket);
    Agent getAgentForTicket(String ticketId);
}
