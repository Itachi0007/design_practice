package managers;

import models.Sprint;
import models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class SprintManager {
    private Map<Integer, Sprint> sprintMap;

    public SprintManager() {
        this.sprintMap = new HashMap<>();
    }

    public Sprint createSprint() {
        // any validations
        // add that new sprint to my list
        Sprint newSprint = new Sprint();
        sprintMap.put(newSprint.getSprintId(), newSprint);
        System.out.println("NEW SPRINT CREATED: " + newSprint.getSprintId());
        return newSprint;
    }

    public void addStoryToSprint(Ticket ticket, Sprint targetSprint) {
        // also add validations for business whether only story can be added etc..

        // iterate my sprint map and add the story-ticket to the respective sprint
        if(sprintMap.containsValue(targetSprint)) {
            targetSprint.getCurrentTickets().add(ticket);
            sprintMap.put(targetSprint.getSprintId(), targetSprint);
            System.out.println("SUCCESS: Added new Ticket: " + ticket.getId()
                    + " to Sprint: " + targetSprint.getSprintId());
        } else {
            System.out.println("ERROR: Sprint not found");
        }
    }

    public void removeStoryFromSprint(Ticket ticket, Sprint targetSprint) {
        // also add validations for business whether only story can be added etc..

        // iterate my sprint map and remove story-ticket from the respective sprint
        if(sprintMap.containsValue(targetSprint)) {
            targetSprint.getCurrentTickets().remove(ticket);
            sprintMap.put(targetSprint.getSprintId(), targetSprint);
        } else {
            System.out.println("ERROR: Sprint not found");
        }
    }


}
