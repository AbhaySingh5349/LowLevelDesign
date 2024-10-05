package Questions.TicketResolutionSystem.repository;

import Questions.TicketResolutionSystem.model.Agent;
import Questions.TicketResolutionSystem.model.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InMemoryAgentRepo implements IAgentRepo{
    Map<String, Agent> agentMap;
    Map<String, List<Ticket>> agentToTicketMapList;

    @Override
    public Agent save(Agent agent) {
        String id = agent.getId();

        agentMap.put(id, agent);
        return agent;
    }

    @Override
    public List<Agent> getAllAgents() {
        return new ArrayList<>(agentMap.values());
    }

    @Override
    public void assignTicketToAgent(String agentId, Ticket ticket) {
        agentToTicketMapList.computeIfAbsent(agentId, k -> new ArrayList<>()).add(ticket);
    }
}
