package Questions.TicketResolutionSystem.strategy;

import Questions.TicketResolutionSystem.model.Agent;
import Questions.TicketResolutionSystem.model.Ticket;
import Questions.TicketResolutionSystem.service.AgentService;

public class AgentWorkerPostTicketResolutionSubscriber implements IPostTicketResolutionSubscriber{
    private AgentService agentService;

    @Override
    public void consume(Ticket ticket, Agent agent) {

    }
}
