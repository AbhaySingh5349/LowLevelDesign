package Questions.TicketResolutionSystem.strategy;

import Questions.TicketResolutionSystem.enums.AgentPreferenceStrategy;
import Questions.TicketResolutionSystem.model.Agent;

import java.util.List;

public interface IAgentPreferenceStrategy {
    boolean doesSupport(AgentPreferenceStrategy agentPreferenceStrategy);
    Agent preferredAgent(List<Agent> agents);
}
