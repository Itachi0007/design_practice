package managers;

import models.Ticket;

import java.util.ArrayList;
import java.util.List;

public class Sprint {
    private List<Ticket> currentTickets;

    public Sprint() {
        this.currentTickets = new ArrayList<>();
    }

    public void addStoryToSprint(Ticket story) {
        currentTickets.add(story);
        System.out.println("Added new Ticket to Sprint: " + story.toString());
        displaySprint();
    }

    public void removeStoryFromSprint(int storyId) {
        currentTickets.remove(storyId);
    }

    public void displaySprint() {
        System.out.println("Sprint Tickets: " + currentTickets);
    }
}