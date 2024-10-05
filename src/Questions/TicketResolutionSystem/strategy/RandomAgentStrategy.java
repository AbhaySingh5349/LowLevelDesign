package Questions.TicketResolutionSystem.strategy;

import Questions.TicketResolutionSystem.enums.AgentPreferenceStrategy;
import Questions.TicketResolutionSystem.model.Agent;

import java.util.List;
import java.util.Random;

public class RandomAgentStrategy implements IAgentPreferenceStrategy{
    @Override
    public boolean doesSupport(AgentPreferenceStrategy agentPreferenceStrategy) {
        return agentPreferenceStrategy.equals(AgentPreferenceStrategy.RANDOM);
    }

    @Override
    public Agent preferredAgent(List<Agent> agents) {
        Random random = new Random();
        int idx = random.nextInt(agents.size());
        return agents.get(idx);
    }
}
