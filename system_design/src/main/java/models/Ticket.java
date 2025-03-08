package models;

import utils.FlowStatus;

import java.util.ArrayList;
import java.util.List;


public abstract class Ticket {
    private static int idCounter = 1;
    protected int id;
    protected String title;
    protected TicketType type;
    protected TicketStatus status;
    protected List<Ticket> subTasks;

    public Ticket(String title, TicketType type) {
        this.id = idCounter++;
        this.title = title;
        this.type = type;
        this.subTasks = new ArrayList<>();
        this.status = TicketStatus.OPEN; // Default status
    }

    public int getId() { return id; }
    public TicketStatus getStatus() { return status; }
    public TicketType getType() { return type; }

    public boolean setStatus(TicketStatus newStatus) {
        if (FlowStatus.isValidTransition(type, this.status, newStatus)) {
            System.out.println("Ticket-" + this.id + ": Updated from " + this.status + " to " + newStatus);
            this.status = newStatus;
            return true;
        } else {
            System.out.println("Ticket-" + this.id + ": Invalid status transition from " + this.status + " to " + newStatus);
            return false;
        }
    }

    @Override
    public String toString() {
        return "Ticket{" + "id=" + id + ", title='" + title + '\'' + ", type=" + type + ", status=" + status + '}';
    }
}
