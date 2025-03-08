package managers;

import models.Sprint;
import models.Ticket;
import models.TicketInstances.StoryTicket;

import java.util.ArrayList;
import java.util.List;

public class SprintManager {
    private List<Ticket> currentSprint;

    public SprintManager() {
        this.currentSprint = new ArrayList<>();
    }

    public void addStoryToSprint(Ticket story) {
        currentSprint.add(story);
        System.out.println("Added new Ticket to Sprint");
        displaySprint();
    }

    public void removeStoryFromSprint(int storyId) {
        currentSprint.remove(storyId);
    }

    public void displaySprint() {
        System.out.println(currentSprint);
    }
}