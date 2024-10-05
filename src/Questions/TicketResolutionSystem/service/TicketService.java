package Questions.TicketResolutionSystem.service;

import Questions.TicketResolutionSystem.PostTicketResolutionPubSub;
import Questions.TicketResolutionSystem.enums.AgentPreferenceStrategy;
import Questions.TicketResolutionSystem.enums.TicketDomain;
import Questions.TicketResolutionSystem.enums.TicketStatus;
import Questions.TicketResolutionSystem.model.Agent;
import Questions.TicketResolutionSystem.model.Ticket;
import Questions.TicketResolutionSystem.repository.ITicketRepo;
import Questions.TicketResolutionSystem.strategy.IAgentPreferenceStrategy;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TicketService {
    private final ITicketRepo ticketRepo;
    private final AgentService agentService;
    private final List<IAgentPreferenceStrategy> agentPreferenceStrategies;
    private final PostTicketResolutionPubSub postTicketResolutionPubSub;

    public TicketService(ITicketRepo ticketRepo, AgentService agentService, List<IAgentPreferenceStrategy> agentPreferenceStrategies, PostTicketResolutionPubSub postTicketResolutionPubSub) {
        this.ticketRepo = ticketRepo;
        this.agentService = agentService;
        this.agentPreferenceStrategies = agentPreferenceStrategies;
        this.postTicketResolutionPubSub = postTicketResolutionPubSub;
    }

    public Ticket createTicket(Ticket ticket){
        String id = UUID.randomUUID().toString();

        ticket.setId(id);

        return ticketRepo.save(ticket);
    }

    public Agent assignTicketToAgent(String ticketId, AgentPreferenceStrategy strategy){
        final Ticket ticket = ticketRepo.get(ticketId);

        final List<Agent> agents = agentService.getAllAgents();

        // Filter (OCP problem is here as new filtering strategies may appear, also now it is AND of all filters)
        //                                                   agent.isAvailable() && agent.getTicketDomainList().contains(ticket.getDomain())
        final List<Agent> domainAgents = agents.stream()
                                               .filter(agent -> agent.isAvailable())
                                               .collect(Collectors.toList());

        // sorting / preference (random or best rating)
        IAgentPreferenceStrategy preferredStrategy = agentPreferenceStrategies.stream()
                                                                              .filter(iAgentPreferenceStrategy -> iAgentPreferenceStrategy.doesSupport(strategy))
                                                                              .findAny().orElseThrow();

        Agent agent = preferredStrategy.preferredAgent(domainAgents);
        agent.setAvailable(false);
        ticket.setTicketStatus(TicketStatus.IN_PROGRESS);
        ticketRepo.saveTicketAgent(ticketId, agent);

        return agent;
    }

    public void resolveTicket(Ticket ticket){
        ticketRepo.resolveTicket(ticket);

        Agent agent = ticketRepo.getAgentForTicket(ticket.getId());
        postTicketResolutionPubSub.notifySubs(ticket, agent);
    }
}
