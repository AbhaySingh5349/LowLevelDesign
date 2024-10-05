package Questions.TicketResolutionSystem;

import Questions.TicketResolutionSystem.model.Agent;
import Questions.TicketResolutionSystem.model.Ticket;
import Questions.TicketResolutionSystem.strategy.IPostTicketResolutionSubscriber;

import java.util.ArrayList;
import java.util.List;

// needs to be singleton
public class PostTicketResolutionPubSub {
    List<IPostTicketResolutionSubscriber> subscribers;

    public PostTicketResolutionPubSub() {
        this.subscribers = new ArrayList<>();
    }

    public void addSubscriber(IPostTicketResolutionSubscriber subscriber){
        subscribers.add(subscriber);
    }

    public void notifySubs(Ticket ticket, Agent agent){
        subscribers.forEach(subscriber -> subscriber.consume(ticket, agent));
    }
}
