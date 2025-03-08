package models;

import utils.FlowStatus;

import java.util.UUID;

public class SubTask {
    private final String id;
    private String title;
    private String description;
    private TicketStatus status;
    private final Ticket parentTicket;

    public SubTask(String title, String description, Ticket parentTicket) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.parentTicket = parentTicket;
        this.status = TicketStatus.OPEN; // Default status
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public boolean updateStatus(TicketStatus newStatus) {
        if (FlowStatus.isValidTransition(parentTicket.getType(), this.status, newStatus)) {
            System.out.println("SUCCESS: Status updated for subtask ID-" + this.id + " to " + newStatus);
            this.status = newStatus;
            return true;
        }
        System.out.println("ERROR: Status update failed for Subtask ID-" + this.id +
                " from " + this.status + " to " + newStatus);
        return false;
    }

    public Ticket getParentTicket() {
        return parentTicket;
    }

    @Override
    public String toString() {
        return "SubTask{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", status=" + status +
                '}';
    }
}
