package Questions.TicketResolutionSystem.repository;

import Questions.TicketResolutionSystem.model.Agent;
import Questions.TicketResolutionSystem.model.Ticket;

import java.util.List;

public interface IAgentRepo {
    Agent save(Agent agent);
    List<Agent> getAllAgents();
    void assignTicketToAgent(String agentId, Ticket ticket);
}
