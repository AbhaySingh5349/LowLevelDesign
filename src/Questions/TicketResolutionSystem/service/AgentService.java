package Questions.TicketResolutionSystem.service;

import Questions.TicketResolutionSystem.model.Agent;
import Questions.TicketResolutionSystem.model.Ticket;
import Questions.TicketResolutionSystem.repository.IAgentRepo;

import java.util.List;
import java.util.UUID;

public class AgentService {
    private IAgentRepo agentRepo;

    public Agent createAgent(Agent agent){
        String id = UUID.randomUUID().toString();

        agent.setId(id);
        return agentRepo.save(agent);
    }

    public List<Agent> getAllAgents(){
        return agentRepo.getAllAgents();
    }

    public void assignTicketToAgent(String agentId, Ticket ticket){
        agentRepo.assignTicketToAgent(agentId, ticket);
    }
}
