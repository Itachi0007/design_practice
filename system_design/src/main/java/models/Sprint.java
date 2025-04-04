package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sprint {
    private static int idCounter = 0;
    private Integer sprintId;
    private List<Ticket> currentTickets;

    public Sprint() {
        this.currentTickets = new ArrayList<>();
        this.sprintId = idCounter++;
    }

    public Integer getSprintId() {
        return sprintId;
    }

    public List<Ticket> getCurrentTickets() {
        return currentTickets;
    }

    public void displaySprint() {
        System.out.println("Sprint Tickets: " + currentTickets);
    }
}