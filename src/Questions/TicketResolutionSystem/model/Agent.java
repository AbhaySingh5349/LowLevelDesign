package Questions.TicketResolutionSystem.model;

import Questions.TicketResolutionSystem.enums.TicketDomain;

import java.util.List;

public class Agent {
    private String id;
    private final String name;
    private final List<TicketDomain> ticketDomainList;
//    private Ticket assignedTicket; // we will try handling this while assigning new ticket in Ticket Service
    private double rating;
    private boolean isAvailable;

    public Agent(String name, List<TicketDomain> ticketDomainList, Ticket assignedTicket) {
        this.name = name;
        this.ticketDomainList = ticketDomainList;
        this.rating = 0.0;
        this.isAvailable = true;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<TicketDomain> getTicketDomainList() {
        return ticketDomainList;
    }

    public double getRating() {
        return rating;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRating(double rating) {
        this.rating += (rating > 5 ? 5:rating);
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
}
