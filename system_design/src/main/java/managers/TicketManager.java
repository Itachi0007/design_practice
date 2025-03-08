package managers;

import models.Ticket;
import models.TicketInstances.EpicTicket;
import models.TicketInstances.OnCallTicket;
import models.TicketInstances.StoryTicket;
import models.TicketStatus;
import models.TicketType;

import java.util.HashMap;
import java.util.Map;

public class TicketManager {
    private Map<Integer, Ticket> ticketMap;
    private Sprint sprint = new Sprint();

    public TicketManager() {
        this.ticketMap = new HashMap<>();
    }

    public Ticket createTicket(String title, TicketType type) {
        Ticket ticket;
        switch (type) {
            case STORY:
                ticket = new StoryTicket(title);
                // only story tickets can be added in the SPRINT
                sprint.addStoryToSprint(ticket);
                break;
            case EPIC:
                ticket = new EpicTicket(title);
                break;
            case ON_CALL:
                ticket = new OnCallTicket(title);
                break;
            default:
                throw new IllegalArgumentException("Invalid ticket type");
        }
        ticketMap.put(ticket.getId(), ticket);
        return ticket;
    }

    public void updateTicketStatus(int ticketId, TicketStatus newStatus) {
        if (ticketMap.containsKey(ticketId)) {
            Ticket ticket = ticketMap.get(ticketId);
            boolean success = ticket.setStatus(newStatus);
        } else {
            System.out.println("Ticket not found!");
        }
    }

    public Ticket getTicket(int ticketId) {
        return ticketMap.get(ticketId);
    }

    public void deleteTicket(int ticketId) {
        ticketMap.remove(ticketId);
    }
}