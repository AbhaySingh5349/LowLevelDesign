package Questions.TicketResolutionSystem.strategy;

import Questions.TicketResolutionSystem.model.Agent;
import Questions.TicketResolutionSystem.model.Ticket;

public interface IPostTicketResolutionSubscriber {
    void consume(Ticket ticket, Agent agent);
}
