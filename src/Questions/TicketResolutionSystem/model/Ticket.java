package Questions.TicketResolutionSystem.model;

import Questions.TicketResolutionSystem.enums.TicketDomain;
import Questions.TicketResolutionSystem.enums.TicketPriority;
import Questions.TicketResolutionSystem.enums.TicketStatus;

import java.util.Date;
import java.util.List;

public class Ticket {
    private String id;
    private final String title;
    private final String details;
    private final TicketDomain domain;
    private final TicketPriority priority;
    private TicketStatus ticketStatus;
    private final Date createdAt;
    private Date resolvedAt;

    public Ticket(String title, String details, TicketDomain domain, TicketPriority priority, Date createdAt) {
        this.title = title;
        this.details = details;
        this.domain = domain;
        this.priority = priority;
        this.ticketStatus = TicketStatus.CREATED;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public TicketDomain getDomain() {
        return domain;
    }

    public TicketPriority getPriority() {
        return priority;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getResolvedAt() {
        return resolvedAt;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public void setResolvedAt(Date resolvedAt) {
        this.resolvedAt = resolvedAt;
    }
}
