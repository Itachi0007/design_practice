import models.Sprint;
import managers.SprintManager;
import managers.TicketManager;
import models.SubTask;
import models.Ticket;
import models.TicketStatus;
import models.TicketType;

public class Driver {
    public static void main(String[] args) {
        TicketManager ticketManager = new TicketManager();
        SprintManager sprintManager = new SprintManager();

        // Create a new sprint
        Sprint sprint1 = sprintManager.createSprint();

        // Testing story Ticket
        Ticket logoutTicket = ticketManager.createTicket("Implement LOGOUT feature", TicketType.STORY);
        Ticket LoginTicket = ticketManager.createTicket("Implement LOGIN feature", TicketType.STORY);

        // Add LOGIN feature to sprint
        sprintManager.addStoryToSprint(LoginTicket, sprint1);

        // Valid Status Updates
        ticketManager.updateTicketStatus(logoutTicket.getId(), TicketStatus.IN_PROGRESS);
        ticketManager.updateTicketStatus(logoutTicket.getId(), TicketStatus.TESTING);
        ticketManager.updateTicketStatus(logoutTicket.getId(), TicketStatus.IN_REVIEW);
        ticketManager.updateTicketStatus(logoutTicket.getId(), TicketStatus.DEPLOYED);
        // Invalid Status Update (Trying to revert status)
        ticketManager.updateTicketStatus(logoutTicket.getId(), TicketStatus.TESTING);
        // Story Ticket completed
        System.out.println(logoutTicket);


        // Using EPIC ticket to test subtask flow for 2 cases on same parent
        Ticket epicTicket = ticketManager.createTicket("Revamp UI", TicketType.EPIC);
        Ticket onCallTicket = ticketManager.createTicket("Fix production issue", TicketType.ON_CALL);

        SubTask subTaskEpic = new SubTask("Design Login UI", "Create UI for login page", epicTicket);
        SubTask subTaskOnCall = new SubTask("Implement API", "Develop backend API for login", onCallTicket);

        System.out.println("\nInitiating SubTasks:");
        System.out.println(subTaskEpic);
        System.out.println(subTaskOnCall);

        System.out.println("\nUpdating SubTask Status:");
        subTaskEpic.updateStatus(TicketStatus.IN_PROGRESS);
        subTaskOnCall.updateStatus(TicketStatus.IN_PROGRESS);
        // Testing fail case as we cant update EPIC subtask to TESTING
        System.out.println("\nTesting the EPIC subtask as per its flow:");
        subTaskEpic.updateStatus(TicketStatus.RESOLVED);
        subTaskEpic.updateStatus(TicketStatus.TESTING);
        subTaskOnCall.updateStatus(TicketStatus.RESOLVED);
        System.out.println(subTaskEpic);
        System.out.println(subTaskOnCall);

        System.out.println("\nProgressing the EPIC subtask as per its flow:");
        subTaskEpic.updateStatus(TicketStatus.COMPLETED);
        // Subtask testing completed
    }
}